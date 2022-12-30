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

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.List;

class SettingsTests {

    private final Settings settings = NullSettings.forUri("file://dev/null");

    @Test
    void testSingleValue() {
        settings.setValue("foo", "bar");
        assertEquals("bar", settings.getValue("foo"));
    }

    @Test
    void testMultipleValues() {
        settings.setValues("themes", List.of("theme1", "theme2"));
        assertEquals(2, settings.getValues("themes").size());
    }
}
