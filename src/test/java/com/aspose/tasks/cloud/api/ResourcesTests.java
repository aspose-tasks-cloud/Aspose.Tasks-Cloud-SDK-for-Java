/*
 * --------------------------------------------------------------------------------
 * <copyright company="Aspose" file="ResourcesTests.java">
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
import com.aspose.tasks.cloud.model.*;
import com.aspose.tasks.cloud.model.requests.*;
import com.aspose.tasks.cloud.model.responses.AsposeResponse;
import com.aspose.tasks.cloud.model.responses.ResourceItemResponse;
import com.aspose.tasks.cloud.model.responses.ResourceItemsResponse;
import com.aspose.tasks.cloud.model.responses.ResourceResponse;
import org.junit.Test;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZoneOffset;

import static org.junit.Assert.assertNotEquals;

import java.io.File;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

/*
 * Example of how to work with resources.
 */
public class ResourcesTests extends TestBase {

    /*
     * Test for get resources.
     */
    @Test
    public void testGetResources() throws Exception {
        String localFileName = "NewProductDev.mpp";
        String remoteFileName = TestInitializer.UploadFile(localFileName);

        GetResourcesRequest request = new GetResourcesRequest(remoteFileName, null, null);
        ResourceItemsResponse result = TestInitializer.tasksApi.getResources(request);

        assertNotNull(result);
        assertNotNull(result.getResources());
        assertEquals(2, result.getResources().getResourceItem().size());
        assertEquals("Project manager", result.getResources().getResourceItem().get(1).getName());
        assertEquals(Integer.valueOf(1), result.getResources().getResourceItem().get(1).getUid());
        assertEquals(Integer.valueOf(1), result.getResources().getResourceItem().get(1).getId());
    }

    /*
     * Test for post resource.
     */
    @Test
    public void testPostResource() throws Exception {
        String localFileName = "Home_move_plan.mpp";
        String remoteFileName = TestInitializer.UploadFile(localFileName);

        GetResourcesRequest getRequest = new GetResourcesRequest(remoteFileName, null, null);
        ResourceItemsResponse getResult = TestInitializer.tasksApi.getResources(getRequest);

        assertEquals(200, (int) getResult.getCode());
        int count = getResult.getResources().getResourceItem().size();

        PostResourceRequest postRequest = new PostResourceRequest(remoteFileName, "new resource", null, null, null, null);
        ResourceItemResponse postResult = TestInitializer.tasksApi.postResource(postRequest);

        assertEquals(201, (int) postResult.getCode());

        getResult = TestInitializer.tasksApi.getResources(getRequest);
        assertEquals(count + 1, getResult.getResources().getResourceItem().size());
        ResourceItem addedResource =  getResult.getResources().getResourceItem().stream().filter(d -> d.getUid() == postResult.getResourceItem().getUid()).findAny().get();
        assertEquals(postRequest.getresourceName(), addedResource.getName());
    }

    /*
     * Test for put resource.
     */
    @Test
    public void testPutResource() throws Exception {
        String localFileName = "sample.mpp";
        String remoteFileName = TestInitializer.UploadFile(localFileName);

        GetResourceRequest getRequest = new GetResourceRequest(remoteFileName, 1, null, null);
        ResourceResponse getResult = TestInitializer.tasksApi.getResource(getRequest);

        assertEquals(200, (int) getResult.getCode());
        assertNotNull(getResult.getResource());

        Baseline baseline = new Baseline();
        baseline.setBaselineNumber(BaselineType.BASELINE1);
        baseline.setCost(BigDecimal.valueOf(44));
        Resource resource = getResult.getResource();
        resource.setName("Modified Resource1");
        resource.setCost(BigDecimal.valueOf(200));
        resource.setStart(OffsetDateTime.of(2000, 10, 10, 0, 0, 0, 0, ZoneOffset.UTC));
        resource.setWork("4.04:10:00");
        resource.setFinish(OffsetDateTime.of(2000, 10, 10, 0, 0, 0, 0, ZoneOffset.UTC));
        resource.setOvertimeWork("4.04:00:00");
        resource.setStandardRate(BigDecimal.valueOf(101));
        resource.setBaselines(Collections.singletonList(baseline));

        PutResourceRequest putRequest = new PutResourceRequest(remoteFileName, 1, resource, CalculationMode.NONE.getValue(), false, null, null, null);
        ResourceResponse putResult = TestInitializer.tasksApi.putResource(putRequest);
        assertEquals(200, (int) putResult.getCode());
        assertEquals(1, putResult.getResource().getBaselines().size());
        assertEquals(resource.getBaselines().get(0).getBaselineNumber(), putResult.getResource().getBaselines().get(0).getBaselineNumber());
        assertEquals(resource.getBaselines().get(0).getCost().intValue(), putResult.getResource().getBaselines().get(0).getCost().intValue());
        assertEquals(resource.getStandardRate().intValue(), putResult.getResource().getStandardRate().intValue());
        assertNotEquals(resource.getStart(), putResult.getResource().getStart());
        assertEquals(resource.getWork(), putResult.getResource().getWork());
        assertNotEquals(resource.getFinish(), putResult.getResource().getFinish());
        assertEquals(resource.getOvertimeWork(), putResult.getResource().getOvertimeWork());
        assertEquals(resource.getCost().intValue(), putResult.getResource().getCost().intValue());
    }

    /*
     * Test for delete resource.
     */
    @Test
    public void testDeleteResource() throws Exception {
        String localFileName = "Plan_with_resource.mpp";
        String remoteFileName = TestInitializer.UploadFile(localFileName);

        GetResourcesRequest getRequest = new GetResourcesRequest(remoteFileName, null, null);
        ResourceItemsResponse getResult = TestInitializer.tasksApi.getResources(getRequest);

        assertEquals(200, (int) getResult.getCode());
        int countBeforeDelete = getResult.getResources().getResourceItem().size();

        DeleteResourceRequest deleteRequest = new DeleteResourceRequest(remoteFileName, 1, null, null, null);
        AsposeResponse deleteResult = TestInitializer.tasksApi.deleteResource(deleteRequest);

        assertEquals(200, (int) deleteResult.getCode());

        getResult = TestInitializer.tasksApi.getResources(getRequest);
        assertTrue(countBeforeDelete > getResult.getResources().getResourceItem().size());
    }
}
