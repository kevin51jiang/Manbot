package com.manbot.plugin

import com.manbot.util.FileUtils
import java.io.File
import java.net.MalformedURLException
import java.net.URLClassLoader
import java.nio.file.FileVisitResult
import java.nio.file.FileVisitResult.CONTINUE
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.SimpleFileVisitor
import java.nio.file.attribute.BasicFileAttributes

/**
 * @author Pavan C (pavan407)
 */
class LocalPluginLoader @Throws(MalformedURLException::class) constructor (val pluginDirectory: Path)
    : SimpleFileVisitor<Path>(), PluginLoader
{
    private val plugins = mutableSetOf<Plugin>()
    private val classLoader = URLClassLoader(arrayOf(pluginDirectory.toUri().toURL()))

    override fun load(): Collection<Plugin>
    {
        Files.walkFileTree(pluginDirectory, this)
        return plugins
    }

    override fun visitFile(filePath: Path, attrs: BasicFileAttributes): FileVisitResult
    {
        try
        {
            // Check if the class is synthetic
            if (filePath.toString().contains("$"))
                return CONTINUE

            // TODO Check file extension
            val classPath = FileUtils.removeExtension(
                    FileUtils.removePath(filePath, pluginDirectory)).toString()
                    .replace(File.separator, ".")

            val clazz = classLoader.loadClass(classPath)
            if (!Plugin::class.java.isAssignableFrom(clazz))
                return CONTINUE

            val plugin = clazz.getConstructor().newInstance()
            plugins += plugin as Plugin

            println("Loaded plugin ${plugin::class.simpleName}.")
        } catch(e: Exception)
        {
            e.printStackTrace()
        }
        return CONTINUE
    }
}
