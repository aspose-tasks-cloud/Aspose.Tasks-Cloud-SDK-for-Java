/*
 * --------------------------------------------------------------------------------
 * <copyright company="Aspose" file="VbaTests.java">
 *   Copyright (c) 2021 Aspose.Tasks Cloud
 * </copyright>
 * <summary>
 *   Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 * </summary>
 * --------------------------------------------------------------------------------
 */

package com.aspose.tasks.cloud.api;

import com.aspose.tasks.cloud.TestBase;
import com.aspose.tasks.cloud.TestInitializer;
import com.aspose.tasks.cloud.model.TimephasedDataType;
import com.aspose.tasks.cloud.model.requests.GetAssignmentTimephasedDataRequest;
import com.aspose.tasks.cloud.model.requests.GetResourceTimephasedDataRequest;
import com.aspose.tasks.cloud.model.requests.GetTaskTimephasedDataRequest;
import com.aspose.tasks.cloud.model.requests.GetVbaProjectRequest;
import com.aspose.tasks.cloud.model.responses.TimephasedDataResponse;
import com.aspose.tasks.cloud.model.responses.VbaProjectResponse;
import org.junit.Test;

/*
 * Example of how to work with VBA.
 */
public class VbaTests extends TestBase {

    /*
     * Test for get vba project.
     */
    @Test
    public void testGetVbaProject() throws Exception {
        String localFileName = "VbaProject3.mpp";
        String remoteFileName = TestInitializer.UploadFile(localFileName);

        GetVbaProjectRequest request = new GetVbaProjectRequest(remoteFileName, null, null);
        VbaProjectResponse result = TestInitializer.tasksApi.getVbaProject(request);
        assertNotNull(result);
        assertEquals(Integer.valueOf(200), result.getCode());
        assertNotNull(result.getVbaProject());
        assertNotNull(result.getVbaProject().getModules());
        assertEquals(8, result.getVbaProject().getModules().size());
        assertEquals("Module1", result.getVbaProject().getModules().get(1).getName());
        assertTrue(result.getVbaProject().getModules().get(1).getSourceCode().startsWith("Type MEMORYSTATUS"));
    }
}
