package com.manbot.util

import java.nio.file.Path
import java.nio.file.Paths

/**
 * @author Pavan C. (pavan407)
 */
object FileUtils
{
    @JvmStatic
    fun removePath(path: String, remove: String): String
    {
        var removed = path.replace(remove, "")

        if (removed.startsWith("\\") || removed.startsWith("/"))
            removed = removed.substring(1)
        return removed
    }

    @JvmStatic
    fun removePath(path: Path, remove: Path): Path
    {
        return Paths.get(removePath(path.toString(), remove.toString()))
    }

    @JvmStatic
    fun removeExtension(file: Path): Path
    {
        //        if (!Files.isRegularFile(file))
        //            return null;
        val fileStr = file.toString()
        return Paths.get(fileStr.substring(0, fileStr.lastIndexOf(".")))
    }
}