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
package com.itsaky.attrinfo;

import android.content.Context;
import android.content.res.Resources;
import com.itsaky.attrinfo.models.Attr;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class AttrInfo {
    
    private final Map<String, Attr> attrs;
    
    public AttrInfo(Context ctx) throws IOException {
        this.attrs = new HashMap<>();
        readAttributes(ctx.getResources());
    }
    
    public Map<String, Attr> getAttrs() {
        return this.attrs;
    }

    private void readAttributes(Resources resources) throws IOException {
        final InputStream in = resources.openRawResource(com.itsaky.sdkinfo.R.raw.attrs);
        
        if(in == null) return;
        
        Document doc = Jsoup.parse(in, null, "file://android_res/");
        Elements attrs = doc.getElementsByTag("resources").first().getElementsByTag("attr");
        for(Element attr : attrs) {
            Attr a = new Attr(attr.attr("name"), true);
            if(a.name.contains(":")) {
                String[] split = a.name.split(":");
                a.prefix = split[0];
                a.name = split[1];
            }
            if(attr.hasAttr("format") && attr.attr("format").contains("boolean")) {
                a.possibleValues.add("true");
                a.possibleValues.add("false");
            }
            Elements enums = attr.getElementsByTag("enum");
            Elements flags = attr.getElementsByTag("flag");
            if(enums != null && enums.size() > 0) {
                for(Element e : enums)
                    a.possibleValues.add(e.attr("name"));
            }
            if(flags != null && flags.size() > 0) {
                for(Element e : flags)
                    a.possibleValues.add(e.attr("name"));
            }
            if(this.attrs.containsKey(a.name)) {
                Attr b = this.attrs.get(a.name);
                if(b != null && b.hasPossibleValues())
                    a.possibleValues.addAll(b.possibleValues);
            }
            this.attrs.put(a.name, a);
        }
    }
}
