/**
 * Copyright (c) 2013, Anthony Schiochet and Eric Citaire
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * * The names Anthony Schiochet and Eric Citaire may not be used to endorse or promote products
 *   derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL MICHAEL BOSTOCK BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY
 * OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.github.gwtd3.demo.client.testcases.arrays;

import com.github.gwtd3.api.D3;
import com.github.gwtd3.api.JsArrays;
import com.github.gwtd3.api.arrays.Array;
import com.github.gwtd3.demo.client.test.AbstractTestCase;

import com.google.gwt.user.client.ui.ComplexPanel;

/**
 * Test D3 array functions.
 * 
 * @author <a href="mailto:schiochetanthoni@gmail.com">Anthony Schiochet</a>
 * 
 */
public class TestD3Arrays extends AbstractTestCase {

    @Override
    public void doTest(final ComplexPanel sandbox) {
        testMaxAndMin();

    }

    private void testMaxAndMin() {
        assertEquals(200, D3.max(JsArrays.asJsArray(52, 200, 31)).asInt());
        assertEquals(52, D3.max(Array.create("52", "200", "31")).asInt());
        assertEquals(205, D3.max(JsArrays.asJsArray(52, 200, 31), Callbacks.add(5)).asInt());
        assertEquals(205, D3.max(Array.create("52", "200", "31"), Callbacks.add(5)).asInt());

        assertEquals(31, D3.min(JsArrays.asJsArray(52, 200, 31)).asInt());
        assertEquals(200, D3.min(Array.create("52", "200", "31")).asInt());
        assertEquals(36, D3.min(JsArrays.asJsArray(52, 200, 31), Callbacks.add(5)).asInt());
        assertEquals(36, D3.min(Array.create("52", "200", "31"), Callbacks.add(5)).asInt());

        System.out.println(D3.max(Array.create()));
        assertTrue(D3.min(Array.create()).isUndefined());
        assertTrue(D3.max(Array.create()).isUndefined());

    }

}
