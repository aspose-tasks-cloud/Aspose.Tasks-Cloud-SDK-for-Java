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
import com.aspose.tasks.cloud.model.CreateVbaModuleRequest;
import com.aspose.tasks.cloud.model.UpdateVbaModuleRequest;
import com.aspose.tasks.cloud.model.VbaModuleType;
import com.aspose.tasks.cloud.model.requests.ClearVbaRequest;
import com.aspose.tasks.cloud.model.requests.DeleteVbaModuleRequest;
import com.aspose.tasks.cloud.model.requests.GetVbaModuleRequest;
import com.aspose.tasks.cloud.model.requests.GetVbaProjectRequest;
import com.aspose.tasks.cloud.model.requests.PostVbaModuleRequest;
import com.aspose.tasks.cloud.model.requests.PutVbaModuleRequest;
import com.aspose.tasks.cloud.model.responses.VbaModuleResponse;
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

    /*
     * Test for get vba module by index.
     */
    @Test
    public void testGetVbaModuleByIndex() throws Exception {
        String localFileName = "VbaProject3.mpp";
        String remoteFileName = TestInitializer.UploadFile(localFileName);

        GetVbaModuleRequest request = new GetVbaModuleRequest(remoteFileName, "1", null, null);
        VbaModuleResponse result = TestInitializer.tasksApi.getVbaModule(request);
        assertNotNull(result);
        assertEquals(Integer.valueOf(200), result.getCode());
        assertNotNull(result.getModule());
        assertEquals("Module1", result.getModule().getName());
    }

    /*
     * Test for get vba module by name.
     */
    @Test
    public void testGetVbaModuleByName() throws Exception {
        String localFileName = "VbaProject3.mpp";
        String remoteFileName = TestInitializer.UploadFile(localFileName);

        GetVbaModuleRequest request = new GetVbaModuleRequest(remoteFileName, "Module1", null, null);
        VbaModuleResponse result = TestInitializer.tasksApi.getVbaModule(request);
        assertNotNull(result);
        assertEquals(Integer.valueOf(200), result.getCode());
        assertNotNull(result.getModule());
        assertEquals("Module1", result.getModule().getName());
    }

    /*
     * Test for post vba module.
     */
    @Test
    public void testPostVbaModule() throws Exception {
        String localFileName = "VbaProject3.mpp";
        String remoteFileName = TestInitializer.UploadFile(localFileName);

        CreateVbaModuleRequest createRequest = new CreateVbaModuleRequest();
        createRequest.setName("NewModule");
        createRequest.setType(VbaModuleType.PROCEDURALMODULE);
        createRequest.setSourceCode("Sub NewSub\n    MsgBox \"Hello\"\nEnd Sub");

        PostVbaModuleRequest request = new PostVbaModuleRequest(remoteFileName, createRequest, null, null, null);
        VbaModuleResponse result = TestInitializer.tasksApi.postVbaModule(request);
        assertNotNull(result);
        assertEquals(Integer.valueOf(201), result.getCode());
        assertNotNull(result.getModule());
        assertEquals("NewModule", result.getModule().getName());
    }

    /*
     * Test for put vba module.
     */
    @Test
    public void testPutVbaModule() throws Exception {
        String localFileName = "VbaProject3.mpp";
        String remoteFileName = TestInitializer.UploadFile(localFileName);

        GetVbaProjectRequest getProjectRequest = new GetVbaProjectRequest(remoteFileName, null, null);
        VbaProjectResponse projectResponse = TestInitializer.tasksApi.getVbaProject(getProjectRequest);
        assertNotNull(projectResponse);
        assertNotNull(projectResponse.getVbaProject());
        assertNotNull(projectResponse.getVbaProject().getModules());
        assertTrue(projectResponse.getVbaProject().getModules().size() > 0);
        String firstModuleName = projectResponse.getVbaProject().getModules().get(0).getName();

        UpdateVbaModuleRequest updateRequest = new UpdateVbaModuleRequest();
        updateRequest.setSourceCode("Sub UpdatedSub\n    MsgBox \"Updated\"\nEnd Sub");

        PutVbaModuleRequest request = new PutVbaModuleRequest(remoteFileName, firstModuleName, updateRequest, null,
                null, null);
        VbaModuleResponse result = TestInitializer.tasksApi.putVbaModule(request);
        assertNotNull(result);
        assertEquals(Integer.valueOf(200), result.getCode());
        assertNotNull(result.getModule());
        assertEquals(firstModuleName, result.getModule().getName());
        assertEquals("Sub UpdatedSub\n    MsgBox \"Updated\"\nEnd Sub", result.getModule().getSourceCode());
    }

    /*
     * Test for delete vba module.
     */
    @Test
    public void testDeleteVbaModule() throws Exception {
        String localFileName = "VbaProject3.mpp";
        String remoteFileName = TestInitializer.UploadFile(localFileName);

        DeleteVbaModuleRequest request = new DeleteVbaModuleRequest(remoteFileName, "Module1", null, null, null);
        com.aspose.tasks.cloud.model.responses.AsposeResponse result = TestInitializer.tasksApi
                .deleteVbaModule(request);
        assertNotNull(result);
        assertEquals(Integer.valueOf(200), result.getCode());
    }

    /*
     * Test for clear vba.
     */
    @Test
    public void testClearVba() throws Exception {
        String localFileName = "VbaProject3.mpp";
        String remoteFileName = TestInitializer.UploadFile(localFileName);

        ClearVbaRequest request = new ClearVbaRequest(remoteFileName, null, null, null);
        com.aspose.tasks.cloud.model.responses.AsposeResponse result = TestInitializer.tasksApi.clearVba(request);
        assertNotNull(result);
        assertEquals(Integer.valueOf(200), result.getCode());
    }
}
