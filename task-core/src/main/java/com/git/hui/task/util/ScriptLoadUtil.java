package com.git.hui.task.util;

import com.git.hui.task.api.ITask;
import com.git.hui.task.exception.CompileTaskScriptException;
import lombok.extern.slf4j.Slf4j;
import org.mdkt.compiler.InMemoryJavaCompiler;

import java.io.File;

/**
 * Created by @author YiHui in 15:44 18/6/28.
 */
@Slf4j
public class ScriptLoadUtil {

    public static ITask loadScript(File file) {
        try {
            return loadJava(file);
//            return GroovyCompile.compile(file, ITask.class, ScriptLoadUtil.class.getClassLoader());
        } catch (Exception e) {
            log.error("un-expect error! e: ", e);
            return null;
        }
    }

    private static ITask loadJava(File file) throws Exception {
        String sourceCode = org.apache.commons.io.FileUtils.readFileToString(file, "UTF-8");
        String className = getClassName(file);
        Class<ITask> helloClass = (Class<ITask>) InMemoryJavaCompiler.newInstance().compile(className, sourceCode);
        return helloClass.newInstance();
    }

    private static String getClassName(File file) {
        String ab = file.getName();
        String[] a = ab.split(".java");
        return a[0];
    }

}
