/*
 * Copyright 2022 Andreas Schipplock
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.schipplock.settings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NullSettings implements Settings {

    private final Map<String, List<String>> data = new HashMap<>();

    public static Settings forUri(String uri) {
        return new NullSettings();
    }

    @Override
    public void setValue(String key, String value) {
        data.put(key, List.of(value));
    }

    @Override
    public void setValues(String key, List<String> values) {
        data.put(key, values);
    }

    @Override
    public String getValue(String key) {
        return data.get(key).stream().findFirst().get();
    }

    @Override
    public List<String> getValues(String key) {
        return data.get(key);
    }

    @Override
    public void persist() {
        throw new RuntimeException("not implemented");
    }

    @Override
    public void reload() {
        throw new RuntimeException("not implemented");
    }
}
