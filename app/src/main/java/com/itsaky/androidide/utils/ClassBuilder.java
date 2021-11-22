/************************************************************************************
 * This file is part of AndroidIDE.
 *
 * Copyright (C) 2021 Akash Yadav
 *
 * AndroidIDE is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * AndroidIDE is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with AndroidIDE.  If not, see <https://www.gnu.org/licenses/>.
 *
**************************************************************************************/


package com.itsaky.androidide.utils;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import javax.lang.model.element.Modifier;

/**
 * A utility class to generate Java source code
 */
public class ClassBuilder {
    
    public static String createClass(String packageName, String className) {
        return toJavaFile(packageName, newClassSpec(className)).toString();
    }
    
    public static String createInterface(String packageName, String className) {
        return toJavaFile(packageName, newInterfaceSpec(className)).toString();
    }
    
    public static String createEnum(String packageName, String className) {
        return toJavaFile(packageName, newEnumSpec(className)).toString();
    }
    
    public static String createActivity(String packageName, String className) {
        MethodSpec onCreate = MethodSpec.methodBuilder("onCreate")
            .addAnnotation(Override.class)
            .addModifiers(Modifier.PROTECTED)
            .addParameter(android.os.Bundle.class, "savedInstanceState")
            .addStatement("super.onCreate(savedInstanceState)")
            .build();
        
        TypeSpec.Builder activity = newClassSpec(className)
            .toBuilder()
            .superclass(androidx.appcompat.app.AppCompatActivity.class)
            .addMethod(onCreate);
            
        return JavaFile.builder(packageName, activity.build())
            .build()
            .toString();
    }
    
    // TODO: Allow user to choose number of spaces to indent
    // Most probably, get this from preferences
    public static JavaFile toJavaFile(String packageName, TypeSpec type) {
        return JavaFile.builder(packageName, type)
            .indent("    ") // Indent 4 spaces
            .build();
    }
    
    public static TypeSpec newClassSpec(String className) {
        return TypeSpec.classBuilder(className)
            .addModifiers(Modifier.PUBLIC)
            .build();
    }
    
    public static TypeSpec newInterfaceSpec(String className) {
        return TypeSpec.interfaceBuilder(className)
            .addModifiers(Modifier.PUBLIC)
            .build();
    }
    
    public static TypeSpec newEnumSpec(String className) {
        return TypeSpec.enumBuilder(className)
            .addModifiers(Modifier.PUBLIC)
            .addEnumConstant("ENUM_DECLARED")
            .build();
    }
}
