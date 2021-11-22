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


package com.itsaky.androidide.tasks.gradle.plugin;

import com.itsaky.androidide.tasks.BaseGradleTask;
import com.itsaky.androidide.tasks.GradleTask;
import java.io.File;
import java.util.List;
import java.util.Arrays;

public class InitializeIDEProject extends BaseGradleTask {
    
    @Override
    public String getName() {
        return "initializeIDEProject";
    }

    @Override
    public String getCommands() {
        return "initializeIDEProject";
    }

    @Override
    public List<String> getTasks() {
        return Arrays.asList(getCommands());
    }

    @Override
    public int getTaskID() {
        return TASK_INIT_PROJECT;
    }

    @Override
    public boolean canOutput() {
        return true;
    }

    @Override
    public GradleTask.Type getType() {
        return Type.ANDROIDIDE_PLUGIN;
    }
}
