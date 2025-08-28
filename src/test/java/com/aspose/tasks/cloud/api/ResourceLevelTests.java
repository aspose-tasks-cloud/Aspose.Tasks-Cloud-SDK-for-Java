/*
 * --------------------------------------------------------------------------------
 * <copyright company="Aspose" file="ResourceLevelTests.java">
 *   Copyright (c) 2025 Aspose.Tasks Cloud
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
import com.aspose.tasks.cloud.model.LevelingOptions;
import com.aspose.tasks.cloud.model.LevelingOrder;
import com.aspose.tasks.cloud.model.requests.ClearLevelingRequest;
import com.aspose.tasks.cloud.model.requests.LevelTasksRequest;
import com.aspose.tasks.cloud.model.responses.AsposeResponse;
import com.aspose.tasks.cloud.model.responses.LevelingResponse;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/*
 * Example of how to work with resource leveling.
 */
public class ResourceLevelTests extends TestBase {

    /*
     * Test for level tasks without body.
     */
    @Test
    public void testLevelTasksWithoutBody() throws Exception {
        String localFileName = "sample.mpp";
        String remoteFileName = TestInitializer.UploadFile(localFileName);

        LevelTasksRequest request = new LevelTasksRequest(remoteFileName, null, null, null, null);
        LevelingResponse result = TestInitializer.tasksApi.levelTasks(request);

        assertNotNull(result);
        assertEquals(200, (int) result.getCode());
        assertNotNull(result.getAffectedTaskUids());
        assertEquals(2, result.getAffectedTaskUids().size());
    }

    /*
     * Test for level tasks with body.
     */
    @Test
    public void testLevelTasksWithBody() throws Exception {
        String localFileName = "sample.mpp";
        String remoteFileName = TestInitializer.UploadFile(localFileName);

        LevelingOptions options = new LevelingOptions();
        options.setLevelingOrder(LevelingOrder.STANDARD);
        options.setResourceUids(Arrays.asList(2, 999));

        LevelTasksRequest request = new LevelTasksRequest(remoteFileName, options, null, null, null);
        LevelingResponse result = TestInitializer.tasksApi.levelTasks(request);

        assertNotNull(result);
        assertEquals(200, (int) result.getCode());
        assertNotNull(result.getAffectedTaskUids());
        assertEquals(1, result.getAffectedTaskUids().size());
    }

    /*
     * Test for clear leveling without body.
     */
    @Test
    public void testClearLevelingWithoutBody() throws Exception {
        String localFileName = "sample.mpp";
        String remoteFileName = TestInitializer.UploadFile(localFileName);

        ClearLevelingRequest request = new ClearLevelingRequest(remoteFileName, null, null, null, null);
        AsposeResponse result = TestInitializer.tasksApi.clearLeveling(request);

        assertNotNull(result);
        assertEquals(200, (int) result.getCode());
    }

    /*
     * Test for clear leveling with body.
     */
    @Test
    public void testClearLevelingWithBody() throws Exception {
        String localFileName = "sample.mpp";
        String remoteFileName = TestInitializer.UploadFile(localFileName);

        List<Integer> taskUids = Arrays.asList(24, 9999);

        ClearLevelingRequest request = new ClearLevelingRequest(remoteFileName, taskUids, null, null, null);
        AsposeResponse result = TestInitializer.tasksApi.clearLeveling(request);

        assertNotNull(result);
        assertEquals(200, (int) result.getCode());
    }
}
