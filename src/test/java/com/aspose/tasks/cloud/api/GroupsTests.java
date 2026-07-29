/*
 * --------------------------------------------------------------------------------
 * <copyright company="Aspose" file="GroupsTests.java">
 *   Copyright (c) 2026 Aspose.Tasks Cloud
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
import com.aspose.tasks.cloud.model.ResourceGroupBucket;
import com.aspose.tasks.cloud.model.TaskGroupBucket;
import com.aspose.tasks.cloud.model.requests.GetGroupedResourcesRequest;
import com.aspose.tasks.cloud.model.requests.GetGroupedTasksRequest;
import com.aspose.tasks.cloud.model.requests.GetResourceGroupRequest;
import com.aspose.tasks.cloud.model.requests.GetResourceGroupsRequest;
import com.aspose.tasks.cloud.model.requests.GetTaskGroupRequest;
import com.aspose.tasks.cloud.model.requests.GetTaskGroupsRequest;
import com.aspose.tasks.cloud.model.responses.GroupItemsResponse;
import com.aspose.tasks.cloud.model.responses.GroupResponse;
import com.aspose.tasks.cloud.model.responses.GroupedResourcesResponse;
import com.aspose.tasks.cloud.model.responses.GroupedTasksResponse;
import org.junit.Test;

/*
 * Example of how to work with groups.
 */
public class GroupsTests extends TestBase {

    /*
     * Test for get resource groups.
     */
    @Test
    public void testGetResourceGroups() throws Exception {
        String localFileName = "ProjectWithGroups.mpp";
        String remoteFileName = TestInitializer.UploadFile(localFileName);

        GetResourceGroupsRequest request = new GetResourceGroupsRequest(remoteFileName, null, null);
        GroupItemsResponse result = TestInitializer.tasksApi.getResourceGroups(request);

        assertEquals(200, (int) result.getCode());
        assertNotNull(result.getGroups());
        assertNotNull(result.getGroups().getList());
        assertTrue(result.getGroups().getList().size() > 0);
    }

    /*
     * Test for get resource group.
     */
    @Test
    public void testGetResourceGroup() throws Exception {
        String localFileName = "ProjectWithGroups.mpp";
        String remoteFileName = TestInitializer.UploadFile(localFileName);

        GetResourceGroupsRequest listRequest = new GetResourceGroupsRequest(remoteFileName, null, null);
        GroupItemsResponse listResult = TestInitializer.tasksApi.getResourceGroups(listRequest);

        assertEquals(200, (int) listResult.getCode());
        assertTrue(listResult.getGroups().getList().size() > 0);

        Integer groupUid = listResult.getGroups().getList().get(0).getUid();

        GetResourceGroupRequest request = new GetResourceGroupRequest(remoteFileName, groupUid, null, null);
        GroupResponse result = TestInitializer.tasksApi.getResourceGroup(request);

        assertEquals(200, (int) result.getCode());
        assertNotNull(result.getGroup());
        assertEquals(Integer.valueOf(groupUid), result.getGroup().getUid());
        assertNotNull(result.getGroup().getName());
    }

    /*
     * Test for get grouped resources.
     */
    @Test
    public void testGetGroupedResources() throws Exception {
        String localFileName = "ProjectWithGroups.mpp";
        String remoteFileName = TestInitializer.UploadFile(localFileName);

        GetResourceGroupsRequest listRequest = new GetResourceGroupsRequest(remoteFileName, null, null);
        GroupItemsResponse listResult = TestInitializer.tasksApi.getResourceGroups(listRequest);

        assertEquals(200, (int) listResult.getCode());
        assertTrue(listResult.getGroups().getList().size() > 1);

        Integer groupUid = listResult.getGroups().getList().get(1).getUid();

        GetGroupedResourcesRequest request = new GetGroupedResourcesRequest(remoteFileName, groupUid, null, null);
        GroupedResourcesResponse result = TestInitializer.tasksApi.getGroupedResources(request);

        assertEquals(200, (int) result.getCode());
        assertNotNull(result.getBuckets());
        assertTrue(result.getBuckets().size() > 0);

        for (ResourceGroupBucket bucket : result.getBuckets()) {
            assertNotNull(bucket.getKey());
            assertNotNull(bucket.getResources());
        }
    }

    /*
     * Test for get task groups.
     */
    @Test
    public void testGetTaskGroups() throws Exception {
        String localFileName = "ProjectWithGroups.mpp";
        String remoteFileName = TestInitializer.UploadFile(localFileName);

        GetTaskGroupsRequest request = new GetTaskGroupsRequest(remoteFileName, null, null);
        GroupItemsResponse result = TestInitializer.tasksApi.getTaskGroups(request);

        assertEquals(200, (int) result.getCode());
        assertNotNull(result.getGroups());
        assertNotNull(result.getGroups().getList());
        assertTrue(result.getGroups().getList().size() > 1);
    }

    /*
     * Test for get task group.
     */
    @Test
    public void testGetTaskGroup() throws Exception {
        String localFileName = "ProjectWithGroups.mpp";
        String remoteFileName = TestInitializer.UploadFile(localFileName);

        GetTaskGroupsRequest listRequest = new GetTaskGroupsRequest(remoteFileName, null, null);
        GroupItemsResponse listResult = TestInitializer.tasksApi.getTaskGroups(listRequest);

        assertEquals(200, (int) listResult.getCode());
        assertTrue(listResult.getGroups().getList().size() > 1);

        Integer groupUid = listResult.getGroups().getList().get(0).getUid();

        GetTaskGroupRequest request = new GetTaskGroupRequest(remoteFileName, groupUid, null, null);
        GroupResponse result = TestInitializer.tasksApi.getTaskGroup(request);

        assertEquals(200, (int) result.getCode());
        assertNotNull(result.getGroup());
        assertEquals(Integer.valueOf(groupUid), result.getGroup().getUid());
        assertEquals("Percent complete", result.getGroup().getName());
        assertNotNull(result.getGroup().getGroupCriteria());
        assertTrue(result.getGroup().getGroupCriteria().size() > 0);
    }

    /*
     * Test for get grouped tasks.
     */
    @Test
    public void testGetGroupedTasks() throws Exception {
        String localFileName = "ProjectWithGroups.mpp";
        String remoteFileName = TestInitializer.UploadFile(localFileName);

        GetTaskGroupsRequest listRequest = new GetTaskGroupsRequest(remoteFileName, null, null);
        GroupItemsResponse listResult = TestInitializer.tasksApi.getTaskGroups(listRequest);

        assertEquals(200, (int) listResult.getCode());
        assertTrue(listResult.getGroups().getList().size() > 1);

        Integer groupUid = listResult.getGroups().getList().get(0).getUid();

        GetGroupedTasksRequest request = new GetGroupedTasksRequest(remoteFileName, groupUid, null, null);
        GroupedTasksResponse result = TestInitializer.tasksApi.getGroupedTasks(request);

        assertEquals(200, (int) result.getCode());
        assertNotNull(result.getBuckets());
        assertTrue(result.getBuckets().size() > 0);

        for (TaskGroupBucket bucket : result.getBuckets()) {
            assertNotNull(bucket.getKey());
            assertNotNull(bucket.getTasks());
        }
    }
}
