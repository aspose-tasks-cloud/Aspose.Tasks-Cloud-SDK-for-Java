/*
 * --------------------------------------------------------------------------------
 * <copyright company="Aspose">
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

import com.aspose.tasks.cloud.*;
import com.aspose.tasks.cloud.model.*;
import com.aspose.tasks.cloud.model.requests.*;
import com.aspose.tasks.cloud.model.responses.*;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.File;
import java.lang.reflect.Type;
import java.util.*;


public class TasksApi {
    private Integer NotAuth = 401;
    private Integer BadRequest = 400;
    private ApiClient apiClient;

    public TasksApi() {
        this(Configuration.getDefaultApiClient());
    }

    public TasksApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
    /**
     * Build call for copyFile
     * @param request CopyFile request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call copyFileCall(CopyFileRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/storage/file/copy/{srcPath}"
            .replaceAll("\\{" + "srcPath" + "\\}", apiClient.escapeString(request.getsrcPath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destPath", request.getdestPath());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "srcStorageName", request.getsrcStorageName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destStorageName", request.getdestStorageName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "versionId", request.getversionId());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call copyFileValidateBeforeCall(CopyFileRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'srcPath' is set
        if (request.getsrcPath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'srcPath' when calling copyFile");
        }
        
        // verify the required parameter 'destPath' is set
        if (request.getdestPath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'destPath' when calling copyFile");
        }
        

        com.squareup.okhttp.Call call = copyFileCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Copy file
     * 
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void copyFile(CopyFileRequest request) throws ApiException {
        try {
            copyFileWithHttpInfo(request);
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                copyFileWithHttpInfo(request);
            }
            throw ex;
        }
    }

    /**
     * Copy file
     * 
     * @param request CopyFile request with main agrs
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<Void> copyFileWithHttpInfo(CopyFileRequest request) throws ApiException {
        com.squareup.okhttp.Call call = copyFileValidateBeforeCall(request, null, null);
        return apiClient.execute(call);
    }

    /**
     * Copy file (asynchronously)
     * 
     * @param request CopyFile request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call copyFileAsync(CopyFileRequest request, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = copyFileValidateBeforeCall(request, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for deleteFile
     * @param request DeleteFile request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call deleteFileCall(DeleteFileRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/storage/file/{path}"
            .replaceAll("\\{" + "path" + "\\}", apiClient.escapeString(request.getpath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storageName", request.getstorageName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "versionId", request.getversionId());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteFileValidateBeforeCall(DeleteFileRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'path' is set
        if (request.getpath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'path' when calling deleteFile");
        }
        

        com.squareup.okhttp.Call call = deleteFileCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Delete file
     * 
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteFile(DeleteFileRequest request) throws ApiException {
        try {
            deleteFileWithHttpInfo(request);
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                deleteFileWithHttpInfo(request);
            }
            throw ex;
        }
    }

    /**
     * Delete file
     * 
     * @param request DeleteFile request with main agrs
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<Void> deleteFileWithHttpInfo(DeleteFileRequest request) throws ApiException {
        com.squareup.okhttp.Call call = deleteFileValidateBeforeCall(request, null, null);
        return apiClient.execute(call);
    }

    /**
     * Delete file (asynchronously)
     * 
     * @param request DeleteFile request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteFileAsync(DeleteFileRequest request, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteFileValidateBeforeCall(request, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for downloadFile
     * @param request DownloadFile request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call downloadFileCall(DownloadFileRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/storage/file/{path}"
            .replaceAll("\\{" + "path" + "\\}", apiClient.escapeString(request.getpath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storageName", request.getstorageName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "versionId", request.getversionId());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "multipart/form-data"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call downloadFileValidateBeforeCall(DownloadFileRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'path' is set
        if (request.getpath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'path' when calling downloadFile");
        }
        

        com.squareup.okhttp.Call call = downloadFileCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Download file
     * 
     * request DownloadFile request with main agrs
     * @return File
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public File downloadFile(DownloadFileRequest request) throws ApiException {
        try {
            ApiResponse<File> resp = downloadFileWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<File> resp = downloadFileWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Download file
     * 
     * @param request DownloadFile request with main agrs
     * @return ApiResponse&lt;File&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<File> downloadFileWithHttpInfo(DownloadFileRequest request) throws ApiException {
        com.squareup.okhttp.Call call = downloadFileValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<File>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Download file (asynchronously)
     * 
     * @param request DownloadFile request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call downloadFileAsync(DownloadFileRequest request, final ApiCallback<File> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = downloadFileValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<File>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for moveFile
     * @param request MoveFile request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call moveFileCall(MoveFileRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/storage/file/move/{srcPath}"
            .replaceAll("\\{" + "srcPath" + "\\}", apiClient.escapeString(request.getsrcPath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destPath", request.getdestPath());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "srcStorageName", request.getsrcStorageName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destStorageName", request.getdestStorageName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "versionId", request.getversionId());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call moveFileValidateBeforeCall(MoveFileRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'srcPath' is set
        if (request.getsrcPath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'srcPath' when calling moveFile");
        }
        
        // verify the required parameter 'destPath' is set
        if (request.getdestPath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'destPath' when calling moveFile");
        }
        

        com.squareup.okhttp.Call call = moveFileCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Move file
     * 
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void moveFile(MoveFileRequest request) throws ApiException {
        try {
            moveFileWithHttpInfo(request);
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                moveFileWithHttpInfo(request);
            }
            throw ex;
        }
    }

    /**
     * Move file
     * 
     * @param request MoveFile request with main agrs
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<Void> moveFileWithHttpInfo(MoveFileRequest request) throws ApiException {
        com.squareup.okhttp.Call call = moveFileValidateBeforeCall(request, null, null);
        return apiClient.execute(call);
    }

    /**
     * Move file (asynchronously)
     * 
     * @param request MoveFile request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call moveFileAsync(MoveFileRequest request, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = moveFileValidateBeforeCall(request, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for uploadFile
     * @param request UploadFile request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call uploadFileCall(UploadFileRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/storage/file/{path}"
            .replaceAll("\\{" + "path" + "\\}", apiClient.escapeString(request.getpath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storageName", request.getstorageName());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        if (request.getfile() != null)
          localVarFormParams.put("file", request.getfile());

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "multipart/form-data"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call uploadFileValidateBeforeCall(UploadFileRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'path' is set
        if (request.getpath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'path' when calling uploadFile");
        }
        
        // verify the required parameter 'file' is set
        if (request.getfile() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'file' when calling uploadFile");
        }
        

        com.squareup.okhttp.Call call = uploadFileCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Upload file
     * 
     * request UploadFile request with main agrs
     * @return FilesUploadResult
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public FilesUploadResult uploadFile(UploadFileRequest request) throws ApiException {
        try {
            ApiResponse<FilesUploadResult> resp = uploadFileWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<FilesUploadResult> resp = uploadFileWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Upload file
     * 
     * @param request UploadFile request with main agrs
     * @return ApiResponse&lt;FilesUploadResult&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<FilesUploadResult> uploadFileWithHttpInfo(UploadFileRequest request) throws ApiException {
        com.squareup.okhttp.Call call = uploadFileValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<FilesUploadResult>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Upload file (asynchronously)
     * 
     * @param request UploadFile request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call uploadFileAsync(UploadFileRequest request, final ApiCallback<FilesUploadResult> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = uploadFileValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<FilesUploadResult>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for copyFolder
     * @param request CopyFolder request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call copyFolderCall(CopyFolderRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/storage/folder/copy/{srcPath}"
            .replaceAll("\\{" + "srcPath" + "\\}", apiClient.escapeString(request.getsrcPath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destPath", request.getdestPath());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "srcStorageName", request.getsrcStorageName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destStorageName", request.getdestStorageName());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call copyFolderValidateBeforeCall(CopyFolderRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'srcPath' is set
        if (request.getsrcPath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'srcPath' when calling copyFolder");
        }
        
        // verify the required parameter 'destPath' is set
        if (request.getdestPath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'destPath' when calling copyFolder");
        }
        

        com.squareup.okhttp.Call call = copyFolderCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Copy folder
     * 
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void copyFolder(CopyFolderRequest request) throws ApiException {
        try {
            copyFolderWithHttpInfo(request);
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                copyFolderWithHttpInfo(request);
            }
            throw ex;
        }
    }

    /**
     * Copy folder
     * 
     * @param request CopyFolder request with main agrs
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<Void> copyFolderWithHttpInfo(CopyFolderRequest request) throws ApiException {
        com.squareup.okhttp.Call call = copyFolderValidateBeforeCall(request, null, null);
        return apiClient.execute(call);
    }

    /**
     * Copy folder (asynchronously)
     * 
     * @param request CopyFolder request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call copyFolderAsync(CopyFolderRequest request, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = copyFolderValidateBeforeCall(request, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for createFolder
     * @param request CreateFolder request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call createFolderCall(CreateFolderRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/storage/folder/{path}"
            .replaceAll("\\{" + "path" + "\\}", apiClient.escapeString(request.getpath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storageName", request.getstorageName());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call createFolderValidateBeforeCall(CreateFolderRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'path' is set
        if (request.getpath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'path' when calling createFolder");
        }
        

        com.squareup.okhttp.Call call = createFolderCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Create the folder
     * 
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void createFolder(CreateFolderRequest request) throws ApiException {
        try {
            createFolderWithHttpInfo(request);
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                createFolderWithHttpInfo(request);
            }
            throw ex;
        }
    }

    /**
     * Create the folder
     * 
     * @param request CreateFolder request with main agrs
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<Void> createFolderWithHttpInfo(CreateFolderRequest request) throws ApiException {
        com.squareup.okhttp.Call call = createFolderValidateBeforeCall(request, null, null);
        return apiClient.execute(call);
    }

    /**
     * Create the folder (asynchronously)
     * 
     * @param request CreateFolder request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call createFolderAsync(CreateFolderRequest request, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = createFolderValidateBeforeCall(request, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for deleteFolder
     * @param request DeleteFolder request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call deleteFolderCall(DeleteFolderRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/storage/folder/{path}"
            .replaceAll("\\{" + "path" + "\\}", apiClient.escapeString(request.getpath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storageName", request.getstorageName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "recursive", request.getrecursive());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteFolderValidateBeforeCall(DeleteFolderRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'path' is set
        if (request.getpath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'path' when calling deleteFolder");
        }
        

        com.squareup.okhttp.Call call = deleteFolderCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Delete folder
     * 
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteFolder(DeleteFolderRequest request) throws ApiException {
        try {
            deleteFolderWithHttpInfo(request);
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                deleteFolderWithHttpInfo(request);
            }
            throw ex;
        }
    }

    /**
     * Delete folder
     * 
     * @param request DeleteFolder request with main agrs
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<Void> deleteFolderWithHttpInfo(DeleteFolderRequest request) throws ApiException {
        com.squareup.okhttp.Call call = deleteFolderValidateBeforeCall(request, null, null);
        return apiClient.execute(call);
    }

    /**
     * Delete folder (asynchronously)
     * 
     * @param request DeleteFolder request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteFolderAsync(DeleteFolderRequest request, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteFolderValidateBeforeCall(request, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for getFilesList
     * @param request GetFilesList request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getFilesListCall(GetFilesListRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/storage/folder/{path}"
            .replaceAll("\\{" + "path" + "\\}", apiClient.escapeString(request.getpath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storageName", request.getstorageName());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getFilesListValidateBeforeCall(GetFilesListRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'path' is set
        if (request.getpath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'path' when calling getFilesList");
        }
        

        com.squareup.okhttp.Call call = getFilesListCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get all files and folders within a folder
     * 
     * request GetFilesList request with main agrs
     * @return FilesList
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public FilesList getFilesList(GetFilesListRequest request) throws ApiException {
        try {
            ApiResponse<FilesList> resp = getFilesListWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<FilesList> resp = getFilesListWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Get all files and folders within a folder
     * 
     * @param request GetFilesList request with main agrs
     * @return ApiResponse&lt;FilesList&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<FilesList> getFilesListWithHttpInfo(GetFilesListRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getFilesListValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<FilesList>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get all files and folders within a folder (asynchronously)
     * 
     * @param request GetFilesList request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getFilesListAsync(GetFilesListRequest request, final ApiCallback<FilesList> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getFilesListValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<FilesList>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for moveFolder
     * @param request MoveFolder request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call moveFolderCall(MoveFolderRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/storage/folder/move/{srcPath}"
            .replaceAll("\\{" + "srcPath" + "\\}", apiClient.escapeString(request.getsrcPath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destPath", request.getdestPath());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "srcStorageName", request.getsrcStorageName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destStorageName", request.getdestStorageName());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call moveFolderValidateBeforeCall(MoveFolderRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'srcPath' is set
        if (request.getsrcPath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'srcPath' when calling moveFolder");
        }
        
        // verify the required parameter 'destPath' is set
        if (request.getdestPath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'destPath' when calling moveFolder");
        }
        

        com.squareup.okhttp.Call call = moveFolderCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Move folder
     * 
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void moveFolder(MoveFolderRequest request) throws ApiException {
        try {
            moveFolderWithHttpInfo(request);
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                moveFolderWithHttpInfo(request);
            }
            throw ex;
        }
    }

    /**
     * Move folder
     * 
     * @param request MoveFolder request with main agrs
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<Void> moveFolderWithHttpInfo(MoveFolderRequest request) throws ApiException {
        com.squareup.okhttp.Call call = moveFolderValidateBeforeCall(request, null, null);
        return apiClient.execute(call);
    }

    /**
     * Move folder (asynchronously)
     * 
     * @param request MoveFolder request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call moveFolderAsync(MoveFolderRequest request, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = moveFolderValidateBeforeCall(request, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for getDiscUsage
     * @param request GetDiscUsage request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getDiscUsageCall(GetDiscUsageRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/storage/disc";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storageName", request.getstorageName());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getDiscUsageValidateBeforeCall(GetDiscUsageRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = getDiscUsageCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get disc usage
     * 
     * request GetDiscUsage request with main agrs
     * @return DiscUsage
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DiscUsage getDiscUsage(GetDiscUsageRequest request) throws ApiException {
        try {
            ApiResponse<DiscUsage> resp = getDiscUsageWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<DiscUsage> resp = getDiscUsageWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Get disc usage
     * 
     * @param request GetDiscUsage request with main agrs
     * @return ApiResponse&lt;DiscUsage&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<DiscUsage> getDiscUsageWithHttpInfo(GetDiscUsageRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getDiscUsageValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<DiscUsage>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get disc usage (asynchronously)
     * 
     * @param request GetDiscUsage request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getDiscUsageAsync(GetDiscUsageRequest request, final ApiCallback<DiscUsage> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getDiscUsageValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DiscUsage>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getFileVersions
     * @param request GetFileVersions request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getFileVersionsCall(GetFileVersionsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/storage/version/{path}"
            .replaceAll("\\{" + "path" + "\\}", apiClient.escapeString(request.getpath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storageName", request.getstorageName());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getFileVersionsValidateBeforeCall(GetFileVersionsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'path' is set
        if (request.getpath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'path' when calling getFileVersions");
        }
        

        com.squareup.okhttp.Call call = getFileVersionsCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get file versions
     * 
     * request GetFileVersions request with main agrs
     * @return FileVersions
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public FileVersions getFileVersions(GetFileVersionsRequest request) throws ApiException {
        try {
            ApiResponse<FileVersions> resp = getFileVersionsWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<FileVersions> resp = getFileVersionsWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Get file versions
     * 
     * @param request GetFileVersions request with main agrs
     * @return ApiResponse&lt;FileVersions&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<FileVersions> getFileVersionsWithHttpInfo(GetFileVersionsRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getFileVersionsValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<FileVersions>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get file versions (asynchronously)
     * 
     * @param request GetFileVersions request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getFileVersionsAsync(GetFileVersionsRequest request, final ApiCallback<FileVersions> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getFileVersionsValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<FileVersions>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for objectExists
     * @param request ObjectExists request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call objectExistsCall(ObjectExistsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/storage/exist/{path}"
            .replaceAll("\\{" + "path" + "\\}", apiClient.escapeString(request.getpath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storageName", request.getstorageName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "versionId", request.getversionId());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call objectExistsValidateBeforeCall(ObjectExistsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'path' is set
        if (request.getpath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'path' when calling objectExists");
        }
        

        com.squareup.okhttp.Call call = objectExistsCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Check if file or folder exists
     * 
     * request ObjectExists request with main agrs
     * @return ObjectExist
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ObjectExist objectExists(ObjectExistsRequest request) throws ApiException {
        try {
            ApiResponse<ObjectExist> resp = objectExistsWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<ObjectExist> resp = objectExistsWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Check if file or folder exists
     * 
     * @param request ObjectExists request with main agrs
     * @return ApiResponse&lt;ObjectExist&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<ObjectExist> objectExistsWithHttpInfo(ObjectExistsRequest request) throws ApiException {
        com.squareup.okhttp.Call call = objectExistsValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<ObjectExist>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Check if file or folder exists (asynchronously)
     * 
     * @param request ObjectExists request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call objectExistsAsync(ObjectExistsRequest request, final ApiCallback<ObjectExist> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = objectExistsValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ObjectExist>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for storageExists
     * @param request StorageExists request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call storageExistsCall(StorageExistsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/storage/{storageName}/exist"
            .replaceAll("\\{" + "storageName" + "\\}", apiClient.escapeString(request.getstorageName().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call storageExistsValidateBeforeCall(StorageExistsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'storageName' is set
        if (request.getstorageName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'storageName' when calling storageExists");
        }
        

        com.squareup.okhttp.Call call = storageExistsCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Check if storage exists
     * 
     * request StorageExists request with main agrs
     * @return StorageExist
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public StorageExist storageExists(StorageExistsRequest request) throws ApiException {
        try {
            ApiResponse<StorageExist> resp = storageExistsWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<StorageExist> resp = storageExistsWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Check if storage exists
     * 
     * @param request StorageExists request with main agrs
     * @return ApiResponse&lt;StorageExist&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<StorageExist> storageExistsWithHttpInfo(StorageExistsRequest request) throws ApiException {
        com.squareup.okhttp.Call call = storageExistsValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<StorageExist>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Check if storage exists (asynchronously)
     * 
     * @param request StorageExists request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call storageExistsAsync(StorageExistsRequest request, final ApiCallback<StorageExist> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = storageExistsValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<StorageExist>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for deleteAssignment
     * @param request DeleteAssignment request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call deleteAssignmentCall(DeleteAssignmentRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/assignments/{assignmentUid}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()))
            .replaceAll("\\{" + "assignmentUid" + "\\}", apiClient.escapeString(request.getassignmentUid().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fileName", request.getfileName());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteAssignmentValidateBeforeCall(DeleteAssignmentRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling deleteAssignment");
        }
        
        // verify the required parameter 'assignmentUid' is set
        if (request.getassignmentUid() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'assignmentUid' when calling deleteAssignment");
        }
        

        com.squareup.okhttp.Call call = deleteAssignmentCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Deletes a project assignment with all references to it.
     * 
     * request DeleteAssignment request with main agrs
     * @return AsposeResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AsposeResponse deleteAssignment(DeleteAssignmentRequest request) throws ApiException {
        try {
            ApiResponse<AsposeResponse> resp = deleteAssignmentWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<AsposeResponse> resp = deleteAssignmentWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Deletes a project assignment with all references to it.
     * 
     * @param request DeleteAssignment request with main agrs
     * @return ApiResponse&lt;AsposeResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<AsposeResponse> deleteAssignmentWithHttpInfo(DeleteAssignmentRequest request) throws ApiException {
        com.squareup.okhttp.Call call = deleteAssignmentValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Deletes a project assignment with all references to it. (asynchronously)
     * 
     * @param request DeleteAssignment request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteAssignmentAsync(DeleteAssignmentRequest request, final ApiCallback<AsposeResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteAssignmentValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getAssignment
     * @param request GetAssignment request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getAssignmentCall(GetAssignmentRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/assignments/{assignmentUid}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()))
            .replaceAll("\\{" + "assignmentUid" + "\\}", apiClient.escapeString(request.getassignmentUid().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getAssignmentValidateBeforeCall(GetAssignmentRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling getAssignment");
        }
        
        // verify the required parameter 'assignmentUid' is set
        if (request.getassignmentUid() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'assignmentUid' when calling getAssignment");
        }
        

        com.squareup.okhttp.Call call = getAssignmentCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Read project assignment with the specified Uid.
     * 
     * request GetAssignment request with main agrs
     * @return AssignmentResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AssignmentResponse getAssignment(GetAssignmentRequest request) throws ApiException {
        try {
            ApiResponse<AssignmentResponse> resp = getAssignmentWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<AssignmentResponse> resp = getAssignmentWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Read project assignment with the specified Uid.
     * 
     * @param request GetAssignment request with main agrs
     * @return ApiResponse&lt;AssignmentResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<AssignmentResponse> getAssignmentWithHttpInfo(GetAssignmentRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getAssignmentValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<AssignmentResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Read project assignment with the specified Uid. (asynchronously)
     * 
     * @param request GetAssignment request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getAssignmentAsync(GetAssignmentRequest request, final ApiCallback<AssignmentResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getAssignmentValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AssignmentResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getAssignmentTimephasedData
     * @param request GetAssignmentTimephasedData request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getAssignmentTimephasedDataCall(GetAssignmentTimephasedDataRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/assignments/{assignmentUid}/timeScaleData"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()))
            .replaceAll("\\{" + "assignmentUid" + "\\}", apiClient.escapeString(request.getassignmentUid().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "type", request.gettype());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "startDate", request.getstartDate());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "endDate", request.getendDate());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getAssignmentTimephasedDataValidateBeforeCall(GetAssignmentTimephasedDataRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling getAssignmentTimephasedData");
        }
        
        // verify the required parameter 'assignmentUid' is set
        if (request.getassignmentUid() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'assignmentUid' when calling getAssignmentTimephasedData");
        }
        

        com.squareup.okhttp.Call call = getAssignmentTimephasedDataCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get timescaled data for an assignment with the specified Uid.
     * 
     * request GetAssignmentTimephasedData request with main agrs
     * @return TimephasedDataResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public TimephasedDataResponse getAssignmentTimephasedData(GetAssignmentTimephasedDataRequest request) throws ApiException {
        try {
            ApiResponse<TimephasedDataResponse> resp = getAssignmentTimephasedDataWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<TimephasedDataResponse> resp = getAssignmentTimephasedDataWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Get timescaled data for an assignment with the specified Uid.
     * 
     * @param request GetAssignmentTimephasedData request with main agrs
     * @return ApiResponse&lt;TimephasedDataResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<TimephasedDataResponse> getAssignmentTimephasedDataWithHttpInfo(GetAssignmentTimephasedDataRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getAssignmentTimephasedDataValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<TimephasedDataResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get timescaled data for an assignment with the specified Uid. (asynchronously)
     * 
     * @param request GetAssignmentTimephasedData request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getAssignmentTimephasedDataAsync(GetAssignmentTimephasedDataRequest request, final ApiCallback<TimephasedDataResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getAssignmentTimephasedDataValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<TimephasedDataResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getAssignments
     * @param request GetAssignments request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getAssignmentsCall(GetAssignmentsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/assignments"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getAssignmentsValidateBeforeCall(GetAssignmentsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling getAssignments");
        }
        

        com.squareup.okhttp.Call call = getAssignmentsCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get project&#39;s assignment items.
     * 
     * request GetAssignments request with main agrs
     * @return AssignmentItemsResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AssignmentItemsResponse getAssignments(GetAssignmentsRequest request) throws ApiException {
        try {
            ApiResponse<AssignmentItemsResponse> resp = getAssignmentsWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<AssignmentItemsResponse> resp = getAssignmentsWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Get project&#39;s assignment items.
     * 
     * @param request GetAssignments request with main agrs
     * @return ApiResponse&lt;AssignmentItemsResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<AssignmentItemsResponse> getAssignmentsWithHttpInfo(GetAssignmentsRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getAssignmentsValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<AssignmentItemsResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get project&#39;s assignment items. (asynchronously)
     * 
     * @param request GetAssignments request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getAssignmentsAsync(GetAssignmentsRequest request, final ApiCallback<AssignmentItemsResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getAssignmentsValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AssignmentItemsResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for postAssignment
     * @param request PostAssignment request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call postAssignmentCall(PostAssignmentRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/assignments"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "taskUid", request.gettaskUid());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "resourceUid", request.getresourceUid());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "units", request.getunits());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "cost", request.getcost());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fileName", request.getfileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call postAssignmentValidateBeforeCall(PostAssignmentRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling postAssignment");
        }
        
        // verify the required parameter 'taskUid' is set
        if (request.gettaskUid() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'taskUid' when calling postAssignment");
        }
        
        // verify the required parameter 'resourceUid' is set
        if (request.getresourceUid() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'resourceUid' when calling postAssignment");
        }
        

        com.squareup.okhttp.Call call = postAssignmentCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Adds a new assignment to a project and returns assignment item in a response.
     * 
     * request PostAssignment request with main agrs
     * @return AssignmentItemResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AssignmentItemResponse postAssignment(PostAssignmentRequest request) throws ApiException {
        try {
            ApiResponse<AssignmentItemResponse> resp = postAssignmentWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<AssignmentItemResponse> resp = postAssignmentWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Adds a new assignment to a project and returns assignment item in a response.
     * 
     * @param request PostAssignment request with main agrs
     * @return ApiResponse&lt;AssignmentItemResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<AssignmentItemResponse> postAssignmentWithHttpInfo(PostAssignmentRequest request) throws ApiException {
        com.squareup.okhttp.Call call = postAssignmentValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<AssignmentItemResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Adds a new assignment to a project and returns assignment item in a response. (asynchronously)
     * 
     * @param request PostAssignment request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call postAssignmentAsync(PostAssignmentRequest request, final ApiCallback<AssignmentItemResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = postAssignmentValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AssignmentItemResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for putAssignment
     * @param request PutAssignment request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call putAssignmentCall(PutAssignmentRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getassignment();

        // create path and map variables
        String localVarPath = "/tasks/{name}/assignments/{assignmentUid}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()))
            .replaceAll("\\{" + "assignmentUid" + "\\}", apiClient.escapeString(request.getassignmentUid().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "mode", request.getmode());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "recalculate", request.getrecalculate());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fileName", request.getfileName());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call putAssignmentValidateBeforeCall(PutAssignmentRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling putAssignment");
        }
        
        // verify the required parameter 'assignmentUid' is set
        if (request.getassignmentUid() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'assignmentUid' when calling putAssignment");
        }
        
        // verify the required parameter 'assignment' is set
        if (request.getassignment() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'assignment' when calling putAssignment");
        }
        

        com.squareup.okhttp.Call call = putAssignmentCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Updates resources assignment with the specified Uid.
     * 
     * request PutAssignment request with main agrs
     * @return AssignmentResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AssignmentResponse putAssignment(PutAssignmentRequest request) throws ApiException {
        try {
            ApiResponse<AssignmentResponse> resp = putAssignmentWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<AssignmentResponse> resp = putAssignmentWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Updates resources assignment with the specified Uid.
     * 
     * @param request PutAssignment request with main agrs
     * @return ApiResponse&lt;AssignmentResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<AssignmentResponse> putAssignmentWithHttpInfo(PutAssignmentRequest request) throws ApiException {
        com.squareup.okhttp.Call call = putAssignmentValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<AssignmentResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Updates resources assignment with the specified Uid. (asynchronously)
     * 
     * @param request PutAssignment request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call putAssignmentAsync(PutAssignmentRequest request, final ApiCallback<AssignmentResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = putAssignmentValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AssignmentResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for deleteCalendar
     * @param request DeleteCalendar request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call deleteCalendarCall(DeleteCalendarRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/calendars/{calendarUid}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()))
            .replaceAll("\\{" + "calendarUid" + "\\}", apiClient.escapeString(request.getcalendarUid().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fileName", request.getfileName());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteCalendarValidateBeforeCall(DeleteCalendarRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling deleteCalendar");
        }
        
        // verify the required parameter 'calendarUid' is set
        if (request.getcalendarUid() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'calendarUid' when calling deleteCalendar");
        }
        

        com.squareup.okhttp.Call call = deleteCalendarCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Deletes a project calendar
     * 
     * request DeleteCalendar request with main agrs
     * @return AsposeResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AsposeResponse deleteCalendar(DeleteCalendarRequest request) throws ApiException {
        try {
            ApiResponse<AsposeResponse> resp = deleteCalendarWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<AsposeResponse> resp = deleteCalendarWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Deletes a project calendar
     * 
     * @param request DeleteCalendar request with main agrs
     * @return ApiResponse&lt;AsposeResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<AsposeResponse> deleteCalendarWithHttpInfo(DeleteCalendarRequest request) throws ApiException {
        com.squareup.okhttp.Call call = deleteCalendarValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Deletes a project calendar (asynchronously)
     * 
     * @param request DeleteCalendar request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteCalendarAsync(DeleteCalendarRequest request, final ApiCallback<AsposeResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteCalendarValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for deleteCalendarException
     * @param request DeleteCalendarException request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call deleteCalendarExceptionCall(DeleteCalendarExceptionRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/calendars/{calendarUid}/calendarExceptions/{index}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()))
            .replaceAll("\\{" + "calendarUid" + "\\}", apiClient.escapeString(request.getcalendarUid().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getindex().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fileName", request.getfileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteCalendarExceptionValidateBeforeCall(DeleteCalendarExceptionRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling deleteCalendarException");
        }
        
        // verify the required parameter 'calendarUid' is set
        if (request.getcalendarUid() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'calendarUid' when calling deleteCalendarException");
        }
        
        // verify the required parameter 'index' is set
        if (request.getindex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'index' when calling deleteCalendarException");
        }
        

        com.squareup.okhttp.Call call = deleteCalendarExceptionCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Deletes calendar exception from calendar exceptions collection.
     * 
     * request DeleteCalendarException request with main agrs
     * @return AsposeResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AsposeResponse deleteCalendarException(DeleteCalendarExceptionRequest request) throws ApiException {
        try {
            ApiResponse<AsposeResponse> resp = deleteCalendarExceptionWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<AsposeResponse> resp = deleteCalendarExceptionWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Deletes calendar exception from calendar exceptions collection.
     * 
     * @param request DeleteCalendarException request with main agrs
     * @return ApiResponse&lt;AsposeResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<AsposeResponse> deleteCalendarExceptionWithHttpInfo(DeleteCalendarExceptionRequest request) throws ApiException {
        com.squareup.okhttp.Call call = deleteCalendarExceptionValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Deletes calendar exception from calendar exceptions collection. (asynchronously)
     * 
     * @param request DeleteCalendarException request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteCalendarExceptionAsync(DeleteCalendarExceptionRequest request, final ApiCallback<AsposeResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteCalendarExceptionValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getCalendar
     * @param request GetCalendar request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getCalendarCall(GetCalendarRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/calendars/{calendarUid}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()))
            .replaceAll("\\{" + "calendarUid" + "\\}", apiClient.escapeString(request.getcalendarUid().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getCalendarValidateBeforeCall(GetCalendarRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling getCalendar");
        }
        
        // verify the required parameter 'calendarUid' is set
        if (request.getcalendarUid() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'calendarUid' when calling getCalendar");
        }
        

        com.squareup.okhttp.Call call = getCalendarCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get a project&#39;s calendar with the specified Uid.
     * 
     * request GetCalendar request with main agrs
     * @return CalendarResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CalendarResponse getCalendar(GetCalendarRequest request) throws ApiException {
        try {
            ApiResponse<CalendarResponse> resp = getCalendarWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<CalendarResponse> resp = getCalendarWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Get a project&#39;s calendar with the specified Uid.
     * 
     * @param request GetCalendar request with main agrs
     * @return ApiResponse&lt;CalendarResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<CalendarResponse> getCalendarWithHttpInfo(GetCalendarRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getCalendarValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<CalendarResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get a project&#39;s calendar with the specified Uid. (asynchronously)
     * 
     * @param request GetCalendar request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getCalendarAsync(GetCalendarRequest request, final ApiCallback<CalendarResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getCalendarValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<CalendarResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getCalendarExceptions
     * @param request GetCalendarExceptions request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getCalendarExceptionsCall(GetCalendarExceptionsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/calendars/{calendarUid}/calendarExceptions"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()))
            .replaceAll("\\{" + "calendarUid" + "\\}", apiClient.escapeString(request.getcalendarUid().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getCalendarExceptionsValidateBeforeCall(GetCalendarExceptionsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling getCalendarExceptions");
        }
        
        // verify the required parameter 'calendarUid' is set
        if (request.getcalendarUid() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'calendarUid' when calling getCalendarExceptions");
        }
        

        com.squareup.okhttp.Call call = getCalendarExceptionsCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get a list of calendar&#39;s exceptions.
     * 
     * request GetCalendarExceptions request with main agrs
     * @return CalendarExceptionsResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CalendarExceptionsResponse getCalendarExceptions(GetCalendarExceptionsRequest request) throws ApiException {
        try {
            ApiResponse<CalendarExceptionsResponse> resp = getCalendarExceptionsWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<CalendarExceptionsResponse> resp = getCalendarExceptionsWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Get a list of calendar&#39;s exceptions.
     * 
     * @param request GetCalendarExceptions request with main agrs
     * @return ApiResponse&lt;CalendarExceptionsResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<CalendarExceptionsResponse> getCalendarExceptionsWithHttpInfo(GetCalendarExceptionsRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getCalendarExceptionsValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<CalendarExceptionsResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get a list of calendar&#39;s exceptions. (asynchronously)
     * 
     * @param request GetCalendarExceptions request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getCalendarExceptionsAsync(GetCalendarExceptionsRequest request, final ApiCallback<CalendarExceptionsResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getCalendarExceptionsValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<CalendarExceptionsResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getCalendarWorkWeeks
     * @param request GetCalendarWorkWeeks request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getCalendarWorkWeeksCall(GetCalendarWorkWeeksRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/calendars/{calendarUid}/workWeeks"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()))
            .replaceAll("\\{" + "calendarUid" + "\\}", apiClient.escapeString(request.getcalendarUid().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getCalendarWorkWeeksValidateBeforeCall(GetCalendarWorkWeeksRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling getCalendarWorkWeeks");
        }
        
        // verify the required parameter 'calendarUid' is set
        if (request.getcalendarUid() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'calendarUid' when calling getCalendarWorkWeeks");
        }
        

        com.squareup.okhttp.Call call = getCalendarWorkWeeksCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Gets the collection of work weeks of the specified calendar.
     * 
     * request GetCalendarWorkWeeks request with main agrs
     * @return CalendarWorkWeeksResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CalendarWorkWeeksResponse getCalendarWorkWeeks(GetCalendarWorkWeeksRequest request) throws ApiException {
        try {
            ApiResponse<CalendarWorkWeeksResponse> resp = getCalendarWorkWeeksWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<CalendarWorkWeeksResponse> resp = getCalendarWorkWeeksWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Gets the collection of work weeks of the specified calendar.
     * 
     * @param request GetCalendarWorkWeeks request with main agrs
     * @return ApiResponse&lt;CalendarWorkWeeksResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<CalendarWorkWeeksResponse> getCalendarWorkWeeksWithHttpInfo(GetCalendarWorkWeeksRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getCalendarWorkWeeksValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<CalendarWorkWeeksResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Gets the collection of work weeks of the specified calendar. (asynchronously)
     * 
     * @param request GetCalendarWorkWeeks request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getCalendarWorkWeeksAsync(GetCalendarWorkWeeksRequest request, final ApiCallback<CalendarWorkWeeksResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getCalendarWorkWeeksValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<CalendarWorkWeeksResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getCalendars
     * @param request GetCalendars request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getCalendarsCall(GetCalendarsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/calendars"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getCalendarsValidateBeforeCall(GetCalendarsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling getCalendars");
        }
        

        com.squareup.okhttp.Call call = getCalendarsCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Read project calendar items.
     * 
     * request GetCalendars request with main agrs
     * @return CalendarItemsResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CalendarItemsResponse getCalendars(GetCalendarsRequest request) throws ApiException {
        try {
            ApiResponse<CalendarItemsResponse> resp = getCalendarsWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<CalendarItemsResponse> resp = getCalendarsWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Read project calendar items.
     * 
     * @param request GetCalendars request with main agrs
     * @return ApiResponse&lt;CalendarItemsResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<CalendarItemsResponse> getCalendarsWithHttpInfo(GetCalendarsRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getCalendarsValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<CalendarItemsResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Read project calendar items. (asynchronously)
     * 
     * @param request GetCalendars request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getCalendarsAsync(GetCalendarsRequest request, final ApiCallback<CalendarItemsResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getCalendarsValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<CalendarItemsResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for postCalendar
     * @param request PostCalendar request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call postCalendarCall(PostCalendarRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getcalendar();

        // create path and map variables
        String localVarPath = "/tasks/{name}/calendars"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fileName", request.getfileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call postCalendarValidateBeforeCall(PostCalendarRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling postCalendar");
        }
        
        // verify the required parameter 'calendar' is set
        if (request.getcalendar() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'calendar' when calling postCalendar");
        }
        

        com.squareup.okhttp.Call call = postCalendarCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Adds a new calendar to project file.
     * 
     * request PostCalendar request with main agrs
     * @return CalendarItemResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CalendarItemResponse postCalendar(PostCalendarRequest request) throws ApiException {
        try {
            ApiResponse<CalendarItemResponse> resp = postCalendarWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<CalendarItemResponse> resp = postCalendarWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Adds a new calendar to project file.
     * 
     * @param request PostCalendar request with main agrs
     * @return ApiResponse&lt;CalendarItemResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<CalendarItemResponse> postCalendarWithHttpInfo(PostCalendarRequest request) throws ApiException {
        com.squareup.okhttp.Call call = postCalendarValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<CalendarItemResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Adds a new calendar to project file. (asynchronously)
     * 
     * @param request PostCalendar request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call postCalendarAsync(PostCalendarRequest request, final ApiCallback<CalendarItemResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = postCalendarValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<CalendarItemResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for postCalendarException
     * @param request PostCalendarException request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call postCalendarExceptionCall(PostCalendarExceptionRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getcalendarException();

        // create path and map variables
        String localVarPath = "/tasks/{name}/calendars/{calendarUid}/calendarExceptions"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()))
            .replaceAll("\\{" + "calendarUid" + "\\}", apiClient.escapeString(request.getcalendarUid().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fileName", request.getfileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call postCalendarExceptionValidateBeforeCall(PostCalendarExceptionRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling postCalendarException");
        }
        
        // verify the required parameter 'calendarUid' is set
        if (request.getcalendarUid() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'calendarUid' when calling postCalendarException");
        }
        
        // verify the required parameter 'calendarException' is set
        if (request.getcalendarException() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'calendarException' when calling postCalendarException");
        }
        

        com.squareup.okhttp.Call call = postCalendarExceptionCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Adds a new calendar exception to a calendar.
     * 
     * request PostCalendarException request with main agrs
     * @return AsposeResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AsposeResponse postCalendarException(PostCalendarExceptionRequest request) throws ApiException {
        try {
            ApiResponse<AsposeResponse> resp = postCalendarExceptionWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<AsposeResponse> resp = postCalendarExceptionWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Adds a new calendar exception to a calendar.
     * 
     * @param request PostCalendarException request with main agrs
     * @return ApiResponse&lt;AsposeResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<AsposeResponse> postCalendarExceptionWithHttpInfo(PostCalendarExceptionRequest request) throws ApiException {
        com.squareup.okhttp.Call call = postCalendarExceptionValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Adds a new calendar exception to a calendar. (asynchronously)
     * 
     * @param request PostCalendarException request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call postCalendarExceptionAsync(PostCalendarExceptionRequest request, final ApiCallback<AsposeResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = postCalendarExceptionValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for putCalendar
     * @param request PutCalendar request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call putCalendarCall(PutCalendarRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getcalendar();

        // create path and map variables
        String localVarPath = "/tasks/{name}/calendars"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "calendarUid", request.getcalendarUid());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fileName", request.getfileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call putCalendarValidateBeforeCall(PutCalendarRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling putCalendar");
        }
        
        // verify the required parameter 'calendarUid' is set
        if (request.getcalendarUid() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'calendarUid' when calling putCalendar");
        }
        
        // verify the required parameter 'calendar' is set
        if (request.getcalendar() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'calendar' when calling putCalendar");
        }
        

        com.squareup.okhttp.Call call = putCalendarCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Edits an existing project calendar.
     * 
     * request PutCalendar request with main agrs
     * @return AsposeResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AsposeResponse putCalendar(PutCalendarRequest request) throws ApiException {
        try {
            ApiResponse<AsposeResponse> resp = putCalendarWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<AsposeResponse> resp = putCalendarWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Edits an existing project calendar.
     * 
     * @param request PutCalendar request with main agrs
     * @return ApiResponse&lt;AsposeResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<AsposeResponse> putCalendarWithHttpInfo(PutCalendarRequest request) throws ApiException {
        com.squareup.okhttp.Call call = putCalendarValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Edits an existing project calendar. (asynchronously)
     * 
     * @param request PutCalendar request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call putCalendarAsync(PutCalendarRequest request, final ApiCallback<AsposeResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = putCalendarValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for putCalendarException
     * @param request PutCalendarException request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call putCalendarExceptionCall(PutCalendarExceptionRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getcalendarException();

        // create path and map variables
        String localVarPath = "/tasks/{name}/calendars/{calendarUid}/calendarExceptions/{index}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()))
            .replaceAll("\\{" + "calendarUid" + "\\}", apiClient.escapeString(request.getcalendarUid().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getindex().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fileName", request.getfileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call putCalendarExceptionValidateBeforeCall(PutCalendarExceptionRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling putCalendarException");
        }
        
        // verify the required parameter 'calendarUid' is set
        if (request.getcalendarUid() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'calendarUid' when calling putCalendarException");
        }
        
        // verify the required parameter 'index' is set
        if (request.getindex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'index' when calling putCalendarException");
        }
        
        // verify the required parameter 'calendarException' is set
        if (request.getcalendarException() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'calendarException' when calling putCalendarException");
        }
        

        com.squareup.okhttp.Call call = putCalendarExceptionCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Updates calendar exception.
     * 
     * request PutCalendarException request with main agrs
     * @return AsposeResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AsposeResponse putCalendarException(PutCalendarExceptionRequest request) throws ApiException {
        try {
            ApiResponse<AsposeResponse> resp = putCalendarExceptionWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<AsposeResponse> resp = putCalendarExceptionWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Updates calendar exception.
     * 
     * @param request PutCalendarException request with main agrs
     * @return ApiResponse&lt;AsposeResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<AsposeResponse> putCalendarExceptionWithHttpInfo(PutCalendarExceptionRequest request) throws ApiException {
        com.squareup.okhttp.Call call = putCalendarExceptionValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Updates calendar exception. (asynchronously)
     * 
     * @param request PutCalendarException request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call putCalendarExceptionAsync(PutCalendarExceptionRequest request, final ApiCallback<AsposeResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = putCalendarExceptionValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getCriticalPath
     * @param request GetCriticalPath request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getCriticalPathCall(GetCriticalPathRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/criticalPath"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getCriticalPathValidateBeforeCall(GetCriticalPathRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling getCriticalPath");
        }
        

        com.squareup.okhttp.Call call = getCriticalPathCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Returns the list of the tasks which must be completed on time for a project to finish on schedule. Each task of the project is represented as a task item here, which is light-weighted task representation of the project task..
     * 
     * request GetCriticalPath request with main agrs
     * @return TaskItemsResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public TaskItemsResponse getCriticalPath(GetCriticalPathRequest request) throws ApiException {
        try {
            ApiResponse<TaskItemsResponse> resp = getCriticalPathWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<TaskItemsResponse> resp = getCriticalPathWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Returns the list of the tasks which must be completed on time for a project to finish on schedule. Each task of the project is represented as a task item here, which is light-weighted task representation of the project task..
     * 
     * @param request GetCriticalPath request with main agrs
     * @return ApiResponse&lt;TaskItemsResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<TaskItemsResponse> getCriticalPathWithHttpInfo(GetCriticalPathRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getCriticalPathValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<TaskItemsResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Returns the list of the tasks which must be completed on time for a project to finish on schedule. Each task of the project is represented as a task item here, which is light-weighted task representation of the project task.. (asynchronously)
     * 
     * @param request GetCriticalPath request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getCriticalPathAsync(GetCriticalPathRequest request, final ApiCallback<TaskItemsResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getCriticalPathValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<TaskItemsResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getPageCount
     * @param request GetPageCount request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getPageCountCall(GetPageCountRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/pagecount"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "pageSize", request.getpageSize());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "presentationFormat", request.getpresentationFormat());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "timescale", request.gettimescale());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "startDate", request.getstartDate());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "endDate", request.getendDate());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getPageCountValidateBeforeCall(GetPageCountRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling getPageCount");
        }
        

        com.squareup.okhttp.Call call = getPageCountCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Returns page count for the project to be rendered using given Timescale and PresentationFormat  or specified PageSize.
     * 
     * request GetPageCount request with main agrs
     * @return PageCountResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public PageCountResponse getPageCount(GetPageCountRequest request) throws ApiException {
        try {
            ApiResponse<PageCountResponse> resp = getPageCountWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<PageCountResponse> resp = getPageCountWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Returns page count for the project to be rendered using given Timescale and PresentationFormat  or specified PageSize.
     * 
     * @param request GetPageCount request with main agrs
     * @return ApiResponse&lt;PageCountResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<PageCountResponse> getPageCountWithHttpInfo(GetPageCountRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getPageCountValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<PageCountResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Returns page count for the project to be rendered using given Timescale and PresentationFormat  or specified PageSize. (asynchronously)
     * 
     * @param request GetPageCount request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getPageCountAsync(GetPageCountRequest request, final ApiCallback<PageCountResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getPageCountValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<PageCountResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getProjectIds
     * @param request GetProjectIds request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getProjectIdsCall(GetProjectIdsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/projectids"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getProjectIdsValidateBeforeCall(GetProjectIdsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling getProjectIds");
        }
        

        com.squareup.okhttp.Call call = getProjectIdsCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get Uids of projects contained in the file.
     * 
     * request GetProjectIds request with main agrs
     * @return ProjectIdsResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ProjectIdsResponse getProjectIds(GetProjectIdsRequest request) throws ApiException {
        try {
            ApiResponse<ProjectIdsResponse> resp = getProjectIdsWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<ProjectIdsResponse> resp = getProjectIdsWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Get Uids of projects contained in the file.
     * 
     * @param request GetProjectIds request with main agrs
     * @return ApiResponse&lt;ProjectIdsResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<ProjectIdsResponse> getProjectIdsWithHttpInfo(GetProjectIdsRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getProjectIdsValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<ProjectIdsResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get Uids of projects contained in the file. (asynchronously)
     * 
     * @param request GetProjectIds request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getProjectIdsAsync(GetProjectIdsRequest request, final ApiCallback<ProjectIdsResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getProjectIdsValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ProjectIdsResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getTaskDocument
     * @param request GetTaskDocument request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getTaskDocumentCall(GetTaskDocumentRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "multipart/form-data"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getTaskDocumentValidateBeforeCall(GetTaskDocumentRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling getTaskDocument");
        }
        

        com.squareup.okhttp.Call call = getTaskDocumentCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get a project document.
     * 
     * request GetTaskDocument request with main agrs
     * @return File
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public File getTaskDocument(GetTaskDocumentRequest request) throws ApiException {
        try {
            ApiResponse<File> resp = getTaskDocumentWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<File> resp = getTaskDocumentWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Get a project document.
     * 
     * @param request GetTaskDocument request with main agrs
     * @return ApiResponse&lt;File&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<File> getTaskDocumentWithHttpInfo(GetTaskDocumentRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getTaskDocumentValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<File>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get a project document. (asynchronously)
     * 
     * @param request GetTaskDocument request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getTaskDocumentAsync(GetTaskDocumentRequest request, final ApiCallback<File> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getTaskDocumentValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<File>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getTaskDocumentWithFormat
     * @param request GetTaskDocumentWithFormat request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getTaskDocumentWithFormatCall(GetTaskDocumentWithFormatRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/format"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "format", request.getformat());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "returnAsZipArchive", request.getreturnAsZipArchive());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "multipart/form-data"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getTaskDocumentWithFormatValidateBeforeCall(GetTaskDocumentWithFormatRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling getTaskDocumentWithFormat");
        }
        
        // verify the required parameter 'format' is set
        if (request.getformat() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'format' when calling getTaskDocumentWithFormat");
        }
        

        com.squareup.okhttp.Call call = getTaskDocumentWithFormatCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get a project document in the specified format
     * 
     * request GetTaskDocumentWithFormat request with main agrs
     * @return File
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public File getTaskDocumentWithFormat(GetTaskDocumentWithFormatRequest request) throws ApiException {
        try {
            ApiResponse<File> resp = getTaskDocumentWithFormatWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<File> resp = getTaskDocumentWithFormatWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Get a project document in the specified format
     * 
     * @param request GetTaskDocumentWithFormat request with main agrs
     * @return ApiResponse&lt;File&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<File> getTaskDocumentWithFormatWithHttpInfo(GetTaskDocumentWithFormatRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getTaskDocumentWithFormatValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<File>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get a project document in the specified format (asynchronously)
     * 
     * @param request GetTaskDocumentWithFormat request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getTaskDocumentWithFormatAsync(GetTaskDocumentWithFormatRequest request, final ApiCallback<File> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getTaskDocumentWithFormatValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<File>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for putImportProjectFromDb
     * @param request PutImportProjectFromDb request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call putImportProjectFromDbCall(PutImportProjectFromDbRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getconnectionString();

        // create path and map variables
        String localVarPath = "/tasks/importfromdb";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "databaseType", request.getdatabaseType());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "projectUid", request.getprojectUid());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "filename", request.getfilename());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "format", request.getformat());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "databaseSchema", request.getdatabaseSchema());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call putImportProjectFromDbValidateBeforeCall(PutImportProjectFromDbRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'databaseType' is set
        if (request.getdatabaseType() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'databaseType' when calling putImportProjectFromDb");
        }
        
        // verify the required parameter 'connectionString' is set
        if (request.getconnectionString() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'connectionString' when calling putImportProjectFromDb");
        }
        
        // verify the required parameter 'projectUid' is set
        if (request.getprojectUid() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'projectUid' when calling putImportProjectFromDb");
        }
        
        // verify the required parameter 'filename' is set
        if (request.getfilename() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'filename' when calling putImportProjectFromDb");
        }
        

        com.squareup.okhttp.Call call = putImportProjectFromDbCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Imports project from database with the specified connection string and saves it to specified file with the specified format.
     * 
     * request PutImportProjectFromDb request with main agrs
     * @return AsposeResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AsposeResponse putImportProjectFromDb(PutImportProjectFromDbRequest request) throws ApiException {
        try {
            ApiResponse<AsposeResponse> resp = putImportProjectFromDbWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<AsposeResponse> resp = putImportProjectFromDbWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Imports project from database with the specified connection string and saves it to specified file with the specified format.
     * 
     * @param request PutImportProjectFromDb request with main agrs
     * @return ApiResponse&lt;AsposeResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<AsposeResponse> putImportProjectFromDbWithHttpInfo(PutImportProjectFromDbRequest request) throws ApiException {
        com.squareup.okhttp.Call call = putImportProjectFromDbValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Imports project from database with the specified connection string and saves it to specified file with the specified format. (asynchronously)
     * 
     * @param request PutImportProjectFromDb request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call putImportProjectFromDbAsync(PutImportProjectFromDbRequest request, final ApiCallback<AsposeResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = putImportProjectFromDbValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for putImportProjectFromFile
     * @param request PutImportProjectFromFile request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call putImportProjectFromFileCall(PutImportProjectFromFileRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/import"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "projectUid", request.getprojectUid());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "filename", request.getfilename());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fileType", request.getfileType());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "outputFileFormat", request.getoutputFileFormat());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call putImportProjectFromFileValidateBeforeCall(PutImportProjectFromFileRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling putImportProjectFromFile");
        }
        
        // verify the required parameter 'projectUid' is set
        if (request.getprojectUid() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'projectUid' when calling putImportProjectFromFile");
        }
        
        // verify the required parameter 'filename' is set
        if (request.getfilename() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'filename' when calling putImportProjectFromFile");
        }
        

        com.squareup.okhttp.Call call = putImportProjectFromFileCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Imports project from primavera db formats (Primavera SQLite .db or Primavera xml) and saves it to specified file with the specified format.
     * 
     * request PutImportProjectFromFile request with main agrs
     * @return AsposeResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AsposeResponse putImportProjectFromFile(PutImportProjectFromFileRequest request) throws ApiException {
        try {
            ApiResponse<AsposeResponse> resp = putImportProjectFromFileWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<AsposeResponse> resp = putImportProjectFromFileWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Imports project from primavera db formats (Primavera SQLite .db or Primavera xml) and saves it to specified file with the specified format.
     * 
     * @param request PutImportProjectFromFile request with main agrs
     * @return ApiResponse&lt;AsposeResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<AsposeResponse> putImportProjectFromFileWithHttpInfo(PutImportProjectFromFileRequest request) throws ApiException {
        com.squareup.okhttp.Call call = putImportProjectFromFileValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Imports project from primavera db formats (Primavera SQLite .db or Primavera xml) and saves it to specified file with the specified format. (asynchronously)
     * 
     * @param request PutImportProjectFromFile request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call putImportProjectFromFileAsync(PutImportProjectFromFileRequest request, final ApiCallback<AsposeResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = putImportProjectFromFileValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for putImportProjectFromProjectOnline
     * @param request PutImportProjectFromProjectOnline request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call putImportProjectFromProjectOnlineCall(PutImportProjectFromProjectOnlineRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getguid();

        // create path and map variables
        String localVarPath = "/tasks/{name}/importfromprojectonline"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "siteUrl", request.getsiteUrl());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "userName", request.getuserName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "format", request.getformat());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (request.getxProjectOnlineToken() != null)
          localVarHeaderParams.put("xProjectOnlineToken", apiClient.parameterToString(request.getxProjectOnlineToken()));
if (request.getxSharepointPassword() != null)
          localVarHeaderParams.put("xSharepointPassword", apiClient.parameterToString(request.getxSharepointPassword()));

        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call putImportProjectFromProjectOnlineValidateBeforeCall(PutImportProjectFromProjectOnlineRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling putImportProjectFromProjectOnline");
        }
        
        // verify the required parameter 'guid' is set
        if (request.getguid() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'guid' when calling putImportProjectFromProjectOnline");
        }
        
        // verify the required parameter 'siteUrl' is set
        if (request.getsiteUrl() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'siteUrl' when calling putImportProjectFromProjectOnline");
        }
        

        com.squareup.okhttp.Call call = putImportProjectFromProjectOnlineCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Imports project from Project Online and saves it to specified file.
     * 
     * request PutImportProjectFromProjectOnline request with main agrs
     * @return AsposeResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AsposeResponse putImportProjectFromProjectOnline(PutImportProjectFromProjectOnlineRequest request) throws ApiException {
        try {
            ApiResponse<AsposeResponse> resp = putImportProjectFromProjectOnlineWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<AsposeResponse> resp = putImportProjectFromProjectOnlineWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Imports project from Project Online and saves it to specified file.
     * 
     * @param request PutImportProjectFromProjectOnline request with main agrs
     * @return ApiResponse&lt;AsposeResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<AsposeResponse> putImportProjectFromProjectOnlineWithHttpInfo(PutImportProjectFromProjectOnlineRequest request) throws ApiException {
        com.squareup.okhttp.Call call = putImportProjectFromProjectOnlineValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Imports project from Project Online and saves it to specified file. (asynchronously)
     * 
     * @param request PutImportProjectFromProjectOnline request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call putImportProjectFromProjectOnlineAsync(PutImportProjectFromProjectOnlineRequest request, final ApiCallback<AsposeResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = putImportProjectFromProjectOnlineValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getDocumentProperties
     * @param request GetDocumentProperties request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getDocumentPropertiesCall(GetDocumentPropertiesRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/documentproperties"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getDocumentPropertiesValidateBeforeCall(GetDocumentPropertiesRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling getDocumentProperties");
        }
        

        com.squareup.okhttp.Call call = getDocumentPropertiesCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get a collection of a project&#39;s document properties.
     * 
     * request GetDocumentProperties request with main agrs
     * @return DocumentPropertiesResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DocumentPropertiesResponse getDocumentProperties(GetDocumentPropertiesRequest request) throws ApiException {
        try {
            ApiResponse<DocumentPropertiesResponse> resp = getDocumentPropertiesWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<DocumentPropertiesResponse> resp = getDocumentPropertiesWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Get a collection of a project&#39;s document properties.
     * 
     * @param request GetDocumentProperties request with main agrs
     * @return ApiResponse&lt;DocumentPropertiesResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<DocumentPropertiesResponse> getDocumentPropertiesWithHttpInfo(GetDocumentPropertiesRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getDocumentPropertiesValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<DocumentPropertiesResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get a collection of a project&#39;s document properties. (asynchronously)
     * 
     * @param request GetDocumentProperties request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getDocumentPropertiesAsync(GetDocumentPropertiesRequest request, final ApiCallback<DocumentPropertiesResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getDocumentPropertiesValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DocumentPropertiesResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getDocumentProperty
     * @param request GetDocumentProperty request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getDocumentPropertyCall(GetDocumentPropertyRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/documentproperties/{propertyName}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()))
            .replaceAll("\\{" + "propertyName" + "\\}", apiClient.escapeString(request.getpropertyName().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getDocumentPropertyValidateBeforeCall(GetDocumentPropertyRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling getDocumentProperty");
        }
        
        // verify the required parameter 'propertyName' is set
        if (request.getpropertyName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'propertyName' when calling getDocumentProperty");
        }
        

        com.squareup.okhttp.Call call = getDocumentPropertyCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get a document property by name.
     * 
     * request GetDocumentProperty request with main agrs
     * @return DocumentPropertyResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DocumentPropertyResponse getDocumentProperty(GetDocumentPropertyRequest request) throws ApiException {
        try {
            ApiResponse<DocumentPropertyResponse> resp = getDocumentPropertyWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<DocumentPropertyResponse> resp = getDocumentPropertyWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Get a document property by name.
     * 
     * @param request GetDocumentProperty request with main agrs
     * @return ApiResponse&lt;DocumentPropertyResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<DocumentPropertyResponse> getDocumentPropertyWithHttpInfo(GetDocumentPropertyRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getDocumentPropertyValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<DocumentPropertyResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get a document property by name. (asynchronously)
     * 
     * @param request GetDocumentProperty request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getDocumentPropertyAsync(GetDocumentPropertyRequest request, final ApiCallback<DocumentPropertyResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getDocumentPropertyValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DocumentPropertyResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for postDocumentProperty
     * @param request PostDocumentProperty request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call postDocumentPropertyCall(PostDocumentPropertyRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getproperty();

        // create path and map variables
        String localVarPath = "/tasks/{name}/documentproperties/{propertyName}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()))
            .replaceAll("\\{" + "propertyName" + "\\}", apiClient.escapeString(request.getpropertyName().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "filename", request.getfilename());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call postDocumentPropertyValidateBeforeCall(PostDocumentPropertyRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling postDocumentProperty");
        }
        
        // verify the required parameter 'propertyName' is set
        if (request.getpropertyName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'propertyName' when calling postDocumentProperty");
        }
        
        // verify the required parameter 'property' is set
        if (request.getproperty() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'property' when calling postDocumentProperty");
        }
        

        com.squareup.okhttp.Call call = postDocumentPropertyCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Set/create document property.
     * 
     * request PostDocumentProperty request with main agrs
     * @return DocumentPropertyResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DocumentPropertyResponse postDocumentProperty(PostDocumentPropertyRequest request) throws ApiException {
        try {
            ApiResponse<DocumentPropertyResponse> resp = postDocumentPropertyWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<DocumentPropertyResponse> resp = postDocumentPropertyWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Set/create document property.
     * 
     * @param request PostDocumentProperty request with main agrs
     * @return ApiResponse&lt;DocumentPropertyResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<DocumentPropertyResponse> postDocumentPropertyWithHttpInfo(PostDocumentPropertyRequest request) throws ApiException {
        com.squareup.okhttp.Call call = postDocumentPropertyValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<DocumentPropertyResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Set/create document property. (asynchronously)
     * 
     * @param request PostDocumentProperty request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call postDocumentPropertyAsync(PostDocumentPropertyRequest request, final ApiCallback<DocumentPropertyResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = postDocumentPropertyValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DocumentPropertyResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for putDocumentProperty
     * @param request PutDocumentProperty request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call putDocumentPropertyCall(PutDocumentPropertyRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getproperty();

        // create path and map variables
        String localVarPath = "/tasks/{name}/documentproperties/{propertyName}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()))
            .replaceAll("\\{" + "propertyName" + "\\}", apiClient.escapeString(request.getpropertyName().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "filename", request.getfilename());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call putDocumentPropertyValidateBeforeCall(PutDocumentPropertyRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling putDocumentProperty");
        }
        
        // verify the required parameter 'propertyName' is set
        if (request.getpropertyName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'propertyName' when calling putDocumentProperty");
        }
        
        // verify the required parameter 'property' is set
        if (request.getproperty() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'property' when calling putDocumentProperty");
        }
        

        com.squareup.okhttp.Call call = putDocumentPropertyCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Set/create document property.
     * 
     * request PutDocumentProperty request with main agrs
     * @return DocumentPropertyResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DocumentPropertyResponse putDocumentProperty(PutDocumentPropertyRequest request) throws ApiException {
        try {
            ApiResponse<DocumentPropertyResponse> resp = putDocumentPropertyWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<DocumentPropertyResponse> resp = putDocumentPropertyWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Set/create document property.
     * 
     * @param request PutDocumentProperty request with main agrs
     * @return ApiResponse&lt;DocumentPropertyResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<DocumentPropertyResponse> putDocumentPropertyWithHttpInfo(PutDocumentPropertyRequest request) throws ApiException {
        com.squareup.okhttp.Call call = putDocumentPropertyValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<DocumentPropertyResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Set/create document property. (asynchronously)
     * 
     * @param request PutDocumentProperty request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call putDocumentPropertyAsync(PutDocumentPropertyRequest request, final ApiCallback<DocumentPropertyResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = putDocumentPropertyValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DocumentPropertyResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for deleteExtendedAttributeByIndex
     * @param request DeleteExtendedAttributeByIndex request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call deleteExtendedAttributeByIndexCall(DeleteExtendedAttributeByIndexRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/extendedAttributes/{index}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getindex().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteExtendedAttributeByIndexValidateBeforeCall(DeleteExtendedAttributeByIndexRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling deleteExtendedAttributeByIndex");
        }
        
        // verify the required parameter 'index' is set
        if (request.getindex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'index' when calling deleteExtendedAttributeByIndex");
        }
        

        com.squareup.okhttp.Call call = deleteExtendedAttributeByIndexCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Delete a project extended attribute.
     * 
     * request DeleteExtendedAttributeByIndex request with main agrs
     * @return AsposeResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AsposeResponse deleteExtendedAttributeByIndex(DeleteExtendedAttributeByIndexRequest request) throws ApiException {
        try {
            ApiResponse<AsposeResponse> resp = deleteExtendedAttributeByIndexWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<AsposeResponse> resp = deleteExtendedAttributeByIndexWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Delete a project extended attribute.
     * 
     * @param request DeleteExtendedAttributeByIndex request with main agrs
     * @return ApiResponse&lt;AsposeResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<AsposeResponse> deleteExtendedAttributeByIndexWithHttpInfo(DeleteExtendedAttributeByIndexRequest request) throws ApiException {
        com.squareup.okhttp.Call call = deleteExtendedAttributeByIndexValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Delete a project extended attribute. (asynchronously)
     * 
     * @param request DeleteExtendedAttributeByIndex request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteExtendedAttributeByIndexAsync(DeleteExtendedAttributeByIndexRequest request, final ApiCallback<AsposeResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteExtendedAttributeByIndexValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getExtendedAttributeByIndex
     * @param request GetExtendedAttributeByIndex request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getExtendedAttributeByIndexCall(GetExtendedAttributeByIndexRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/extendedAttributes/{index}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getindex().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getExtendedAttributeByIndexValidateBeforeCall(GetExtendedAttributeByIndexRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling getExtendedAttributeByIndex");
        }
        
        // verify the required parameter 'index' is set
        if (request.getindex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'index' when calling getExtendedAttributeByIndex");
        }
        

        com.squareup.okhttp.Call call = getExtendedAttributeByIndexCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get a project extended attribute definition with the specified index.
     * 
     * request GetExtendedAttributeByIndex request with main agrs
     * @return ExtendedAttributeResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ExtendedAttributeResponse getExtendedAttributeByIndex(GetExtendedAttributeByIndexRequest request) throws ApiException {
        try {
            ApiResponse<ExtendedAttributeResponse> resp = getExtendedAttributeByIndexWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<ExtendedAttributeResponse> resp = getExtendedAttributeByIndexWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Get a project extended attribute definition with the specified index.
     * 
     * @param request GetExtendedAttributeByIndex request with main agrs
     * @return ApiResponse&lt;ExtendedAttributeResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<ExtendedAttributeResponse> getExtendedAttributeByIndexWithHttpInfo(GetExtendedAttributeByIndexRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getExtendedAttributeByIndexValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<ExtendedAttributeResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get a project extended attribute definition with the specified index. (asynchronously)
     * 
     * @param request GetExtendedAttributeByIndex request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getExtendedAttributeByIndexAsync(GetExtendedAttributeByIndexRequest request, final ApiCallback<ExtendedAttributeResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getExtendedAttributeByIndexValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ExtendedAttributeResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getExtendedAttributes
     * @param request GetExtendedAttributes request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getExtendedAttributesCall(GetExtendedAttributesRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/extendedAttributes"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getExtendedAttributesValidateBeforeCall(GetExtendedAttributesRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling getExtendedAttributes");
        }
        

        com.squareup.okhttp.Call call = getExtendedAttributesCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get a project&#39;s extended attributes.
     * 
     * request GetExtendedAttributes request with main agrs
     * @return ExtendedAttributeItemsResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ExtendedAttributeItemsResponse getExtendedAttributes(GetExtendedAttributesRequest request) throws ApiException {
        try {
            ApiResponse<ExtendedAttributeItemsResponse> resp = getExtendedAttributesWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<ExtendedAttributeItemsResponse> resp = getExtendedAttributesWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Get a project&#39;s extended attributes.
     * 
     * @param request GetExtendedAttributes request with main agrs
     * @return ApiResponse&lt;ExtendedAttributeItemsResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<ExtendedAttributeItemsResponse> getExtendedAttributesWithHttpInfo(GetExtendedAttributesRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getExtendedAttributesValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<ExtendedAttributeItemsResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get a project&#39;s extended attributes. (asynchronously)
     * 
     * @param request GetExtendedAttributes request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getExtendedAttributesAsync(GetExtendedAttributesRequest request, final ApiCallback<ExtendedAttributeItemsResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getExtendedAttributesValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ExtendedAttributeItemsResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for putExtendedAttribute
     * @param request PutExtendedAttribute request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call putExtendedAttributeCall(PutExtendedAttributeRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getextendedAttribute();

        // create path and map variables
        String localVarPath = "/tasks/{name}/extendedAttributes"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fileName", request.getfileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call putExtendedAttributeValidateBeforeCall(PutExtendedAttributeRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'extendedAttribute' is set
        if (request.getextendedAttribute() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'extendedAttribute' when calling putExtendedAttribute");
        }
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling putExtendedAttribute");
        }
        

        com.squareup.okhttp.Call call = putExtendedAttributeCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Add a new extended attribute definition to a project or  updates existing attribute definition (with the same FieldId).
     * 
     * request PutExtendedAttribute request with main agrs
     * @return ExtendedAttributeItemResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ExtendedAttributeItemResponse putExtendedAttribute(PutExtendedAttributeRequest request) throws ApiException {
        try {
            ApiResponse<ExtendedAttributeItemResponse> resp = putExtendedAttributeWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<ExtendedAttributeItemResponse> resp = putExtendedAttributeWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Add a new extended attribute definition to a project or  updates existing attribute definition (with the same FieldId).
     * 
     * @param request PutExtendedAttribute request with main agrs
     * @return ApiResponse&lt;ExtendedAttributeItemResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<ExtendedAttributeItemResponse> putExtendedAttributeWithHttpInfo(PutExtendedAttributeRequest request) throws ApiException {
        com.squareup.okhttp.Call call = putExtendedAttributeValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<ExtendedAttributeItemResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Add a new extended attribute definition to a project or  updates existing attribute definition (with the same FieldId). (asynchronously)
     * 
     * @param request PutExtendedAttribute request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call putExtendedAttributeAsync(PutExtendedAttributeRequest request, final ApiCallback<ExtendedAttributeItemResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = putExtendedAttributeValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ExtendedAttributeItemResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for deleteOutlineCodeByIndex
     * @param request DeleteOutlineCodeByIndex request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call deleteOutlineCodeByIndexCall(DeleteOutlineCodeByIndexRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/outlineCodes/{index}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getindex().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteOutlineCodeByIndexValidateBeforeCall(DeleteOutlineCodeByIndexRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling deleteOutlineCodeByIndex");
        }
        
        // verify the required parameter 'index' is set
        if (request.getindex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'index' when calling deleteOutlineCodeByIndex");
        }
        

        com.squareup.okhttp.Call call = deleteOutlineCodeByIndexCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Deletes a project outline code
     * 
     * request DeleteOutlineCodeByIndex request with main agrs
     * @return AsposeResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AsposeResponse deleteOutlineCodeByIndex(DeleteOutlineCodeByIndexRequest request) throws ApiException {
        try {
            ApiResponse<AsposeResponse> resp = deleteOutlineCodeByIndexWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<AsposeResponse> resp = deleteOutlineCodeByIndexWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Deletes a project outline code
     * 
     * @param request DeleteOutlineCodeByIndex request with main agrs
     * @return ApiResponse&lt;AsposeResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<AsposeResponse> deleteOutlineCodeByIndexWithHttpInfo(DeleteOutlineCodeByIndexRequest request) throws ApiException {
        com.squareup.okhttp.Call call = deleteOutlineCodeByIndexValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Deletes a project outline code (asynchronously)
     * 
     * @param request DeleteOutlineCodeByIndex request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteOutlineCodeByIndexAsync(DeleteOutlineCodeByIndexRequest request, final ApiCallback<AsposeResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteOutlineCodeByIndexValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getOutlineCodeByIndex
     * @param request GetOutlineCodeByIndex request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getOutlineCodeByIndexCall(GetOutlineCodeByIndexRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/outlineCodes/{index}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getindex().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getOutlineCodeByIndexValidateBeforeCall(GetOutlineCodeByIndexRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling getOutlineCodeByIndex");
        }
        
        // verify the required parameter 'index' is set
        if (request.getindex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'index' when calling getOutlineCodeByIndex");
        }
        

        com.squareup.okhttp.Call call = getOutlineCodeByIndexCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get outline code by index.
     * 
     * request GetOutlineCodeByIndex request with main agrs
     * @return OutlineCodeResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public OutlineCodeResponse getOutlineCodeByIndex(GetOutlineCodeByIndexRequest request) throws ApiException {
        try {
            ApiResponse<OutlineCodeResponse> resp = getOutlineCodeByIndexWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<OutlineCodeResponse> resp = getOutlineCodeByIndexWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Get outline code by index.
     * 
     * @param request GetOutlineCodeByIndex request with main agrs
     * @return ApiResponse&lt;OutlineCodeResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<OutlineCodeResponse> getOutlineCodeByIndexWithHttpInfo(GetOutlineCodeByIndexRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getOutlineCodeByIndexValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<OutlineCodeResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get outline code by index. (asynchronously)
     * 
     * @param request GetOutlineCodeByIndex request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getOutlineCodeByIndexAsync(GetOutlineCodeByIndexRequest request, final ApiCallback<OutlineCodeResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getOutlineCodeByIndexValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<OutlineCodeResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getOutlineCodes
     * @param request GetOutlineCodes request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getOutlineCodesCall(GetOutlineCodesRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/outlineCodes"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getOutlineCodesValidateBeforeCall(GetOutlineCodesRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling getOutlineCodes");
        }
        

        com.squareup.okhttp.Call call = getOutlineCodesCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get a project&#39;s outline codes.
     * 
     * request GetOutlineCodes request with main agrs
     * @return OutlineCodeItemsResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public OutlineCodeItemsResponse getOutlineCodes(GetOutlineCodesRequest request) throws ApiException {
        try {
            ApiResponse<OutlineCodeItemsResponse> resp = getOutlineCodesWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<OutlineCodeItemsResponse> resp = getOutlineCodesWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Get a project&#39;s outline codes.
     * 
     * @param request GetOutlineCodes request with main agrs
     * @return ApiResponse&lt;OutlineCodeItemsResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<OutlineCodeItemsResponse> getOutlineCodesWithHttpInfo(GetOutlineCodesRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getOutlineCodesValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<OutlineCodeItemsResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get a project&#39;s outline codes. (asynchronously)
     * 
     * @param request GetOutlineCodes request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getOutlineCodesAsync(GetOutlineCodesRequest request, final ApiCallback<OutlineCodeItemsResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getOutlineCodesValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<OutlineCodeItemsResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for createNewProject
     * @param request CreateNewProject request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call createNewProjectCall(CreateNewProjectRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getsaveOptions();

        // create path and map variables
        String localVarPath = "/tasks/projectOnline/{siteUrl}/{name}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()))
            .replaceAll("\\{" + "siteUrl" + "\\}", apiClient.escapeString(request.getsiteUrl().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "userName", request.getuserName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (request.getxProjectOnlineToken() != null)
          localVarHeaderParams.put("xProjectOnlineToken", apiClient.parameterToString(request.getxProjectOnlineToken()));
if (request.getxSharepointPassword() != null)
          localVarHeaderParams.put("xSharepointPassword", apiClient.parameterToString(request.getxSharepointPassword()));

        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call createNewProjectValidateBeforeCall(CreateNewProjectRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling createNewProject");
        }
        
        // verify the required parameter 'siteUrl' is set
        if (request.getsiteUrl() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'siteUrl' when calling createNewProject");
        }
        

        com.squareup.okhttp.Call call = createNewProjectCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Creates new project in Project Server\\Project Online instance.
     * 
     * request CreateNewProject request with main agrs
     * @return AsposeResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AsposeResponse createNewProject(CreateNewProjectRequest request) throws ApiException {
        try {
            ApiResponse<AsposeResponse> resp = createNewProjectWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<AsposeResponse> resp = createNewProjectWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Creates new project in Project Server\\Project Online instance.
     * 
     * @param request CreateNewProject request with main agrs
     * @return ApiResponse&lt;AsposeResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<AsposeResponse> createNewProjectWithHttpInfo(CreateNewProjectRequest request) throws ApiException {
        com.squareup.okhttp.Call call = createNewProjectValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Creates new project in Project Server\\Project Online instance. (asynchronously)
     * 
     * @param request CreateNewProject request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call createNewProjectAsync(CreateNewProjectRequest request, final ApiCallback<AsposeResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = createNewProjectValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getProjectList
     * @param request GetProjectList request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getProjectListCall(GetProjectListRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/projectOnline/projectList";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "siteUrl", request.getsiteUrl());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "userName", request.getuserName());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (request.getxProjectOnlineToken() != null)
          localVarHeaderParams.put("xProjectOnlineToken", apiClient.parameterToString(request.getxProjectOnlineToken()));
if (request.getxSharepointPassword() != null)
          localVarHeaderParams.put("xSharepointPassword", apiClient.parameterToString(request.getxSharepointPassword()));

        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getProjectListValidateBeforeCall(GetProjectListRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'siteUrl' is set
        if (request.getsiteUrl() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'siteUrl' when calling getProjectList");
        }
        

        com.squareup.okhttp.Call call = getProjectListCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Gets the list of published projects in the current Project Online account.
     * 
     * request GetProjectList request with main agrs
     * @return ProjectListResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ProjectListResponse getProjectList(GetProjectListRequest request) throws ApiException {
        try {
            ApiResponse<ProjectListResponse> resp = getProjectListWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<ProjectListResponse> resp = getProjectListWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Gets the list of published projects in the current Project Online account.
     * 
     * @param request GetProjectList request with main agrs
     * @return ApiResponse&lt;ProjectListResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<ProjectListResponse> getProjectListWithHttpInfo(GetProjectListRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getProjectListValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<ProjectListResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Gets the list of published projects in the current Project Online account. (asynchronously)
     * 
     * @param request GetProjectList request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getProjectListAsync(GetProjectListRequest request, final ApiCallback<ProjectListResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getProjectListValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ProjectListResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for updateProject
     * @param request UpdateProject request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call updateProjectCall(UpdateProjectRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getsaveOptions();

        // create path and map variables
        String localVarPath = "/tasks/projectOnline/{siteUrl}/{name}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()))
            .replaceAll("\\{" + "siteUrl" + "\\}", apiClient.escapeString(request.getsiteUrl().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "userName", request.getuserName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (request.getxProjectOnlineToken() != null)
          localVarHeaderParams.put("xProjectOnlineToken", apiClient.parameterToString(request.getxProjectOnlineToken()));
if (request.getxSharepointPassword() != null)
          localVarHeaderParams.put("xSharepointPassword", apiClient.parameterToString(request.getxSharepointPassword()));

        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call updateProjectValidateBeforeCall(UpdateProjectRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling updateProject");
        }
        
        // verify the required parameter 'siteUrl' is set
        if (request.getsiteUrl() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'siteUrl' when calling updateProject");
        }
        

        com.squareup.okhttp.Call call = updateProjectCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Updates existing project in Project Server\\Project Online instance. The existing project will be overwritten.
     * 
     * request UpdateProject request with main agrs
     * @return AsposeResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AsposeResponse updateProject(UpdateProjectRequest request) throws ApiException {
        try {
            ApiResponse<AsposeResponse> resp = updateProjectWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<AsposeResponse> resp = updateProjectWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Updates existing project in Project Server\\Project Online instance. The existing project will be overwritten.
     * 
     * @param request UpdateProject request with main agrs
     * @return ApiResponse&lt;AsposeResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<AsposeResponse> updateProjectWithHttpInfo(UpdateProjectRequest request) throws ApiException {
        com.squareup.okhttp.Call call = updateProjectValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Updates existing project in Project Server\\Project Online instance. The existing project will be overwritten. (asynchronously)
     * 
     * @param request UpdateProject request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updateProjectAsync(UpdateProjectRequest request, final ApiCallback<AsposeResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = updateProjectValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for putRecalculateProject
     * @param request PutRecalculateProject request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call putRecalculateProjectCall(PutRecalculateProjectRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/recalculate/project"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "mode", request.getmode());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "validate", request.getvalidate());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fileName", request.getfileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call putRecalculateProjectValidateBeforeCall(PutRecalculateProjectRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling putRecalculateProject");
        }
        

        com.squareup.okhttp.Call call = putRecalculateProjectCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Reschedules all project tasks ids, outline levels, start/finish dates, sets early/late dates, calculates slacks, work and cost fields.
     * 
     * request PutRecalculateProject request with main agrs
     * @return ProjectRecalculateResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ProjectRecalculateResponse putRecalculateProject(PutRecalculateProjectRequest request) throws ApiException {
        try {
            ApiResponse<ProjectRecalculateResponse> resp = putRecalculateProjectWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<ProjectRecalculateResponse> resp = putRecalculateProjectWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Reschedules all project tasks ids, outline levels, start/finish dates, sets early/late dates, calculates slacks, work and cost fields.
     * 
     * @param request PutRecalculateProject request with main agrs
     * @return ApiResponse&lt;ProjectRecalculateResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<ProjectRecalculateResponse> putRecalculateProjectWithHttpInfo(PutRecalculateProjectRequest request) throws ApiException {
        com.squareup.okhttp.Call call = putRecalculateProjectValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<ProjectRecalculateResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Reschedules all project tasks ids, outline levels, start/finish dates, sets early/late dates, calculates slacks, work and cost fields. (asynchronously)
     * 
     * @param request PutRecalculateProject request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call putRecalculateProjectAsync(PutRecalculateProjectRequest request, final ApiCallback<ProjectRecalculateResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = putRecalculateProjectValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ProjectRecalculateResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for putRecalculateProjectResourceFields
     * @param request PutRecalculateProjectResourceFields request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call putRecalculateProjectResourceFieldsCall(PutRecalculateProjectResourceFieldsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/recalculate/resourceFields"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fileName", request.getfileName());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call putRecalculateProjectResourceFieldsValidateBeforeCall(PutRecalculateProjectResourceFieldsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling putRecalculateProjectResourceFields");
        }
        

        com.squareup.okhttp.Call call = putRecalculateProjectResourceFieldsCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Recalculate project resource fields
     * 
     * request PutRecalculateProjectResourceFields request with main agrs
     * @return AsposeResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AsposeResponse putRecalculateProjectResourceFields(PutRecalculateProjectResourceFieldsRequest request) throws ApiException {
        try {
            ApiResponse<AsposeResponse> resp = putRecalculateProjectResourceFieldsWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<AsposeResponse> resp = putRecalculateProjectResourceFieldsWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Recalculate project resource fields
     * 
     * @param request PutRecalculateProjectResourceFields request with main agrs
     * @return ApiResponse&lt;AsposeResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<AsposeResponse> putRecalculateProjectResourceFieldsWithHttpInfo(PutRecalculateProjectResourceFieldsRequest request) throws ApiException {
        com.squareup.okhttp.Call call = putRecalculateProjectResourceFieldsValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Recalculate project resource fields (asynchronously)
     * 
     * @param request PutRecalculateProjectResourceFields request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call putRecalculateProjectResourceFieldsAsync(PutRecalculateProjectResourceFieldsRequest request, final ApiCallback<AsposeResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = putRecalculateProjectResourceFieldsValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for putRecalculateProjectUncompleteWorkToStartAfter
     * @param request PutRecalculateProjectUncompleteWorkToStartAfter request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call putRecalculateProjectUncompleteWorkToStartAfterCall(PutRecalculateProjectUncompleteWorkToStartAfterRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getafter();

        // create path and map variables
        String localVarPath = "/tasks/{name}/recalculate/uncompleteWorkToStartAfter"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fileName", request.getfileName());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call putRecalculateProjectUncompleteWorkToStartAfterValidateBeforeCall(PutRecalculateProjectUncompleteWorkToStartAfterRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling putRecalculateProjectUncompleteWorkToStartAfter");
        }
        
        // verify the required parameter 'after' is set
        if (request.getafter() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'after' when calling putRecalculateProjectUncompleteWorkToStartAfter");
        }
        

        com.squareup.okhttp.Call call = putRecalculateProjectUncompleteWorkToStartAfterCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Recalculate project uncomplete work
     * 
     * request PutRecalculateProjectUncompleteWorkToStartAfter request with main agrs
     * @return AsposeResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AsposeResponse putRecalculateProjectUncompleteWorkToStartAfter(PutRecalculateProjectUncompleteWorkToStartAfterRequest request) throws ApiException {
        try {
            ApiResponse<AsposeResponse> resp = putRecalculateProjectUncompleteWorkToStartAfterWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<AsposeResponse> resp = putRecalculateProjectUncompleteWorkToStartAfterWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Recalculate project uncomplete work
     * 
     * @param request PutRecalculateProjectUncompleteWorkToStartAfter request with main agrs
     * @return ApiResponse&lt;AsposeResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<AsposeResponse> putRecalculateProjectUncompleteWorkToStartAfterWithHttpInfo(PutRecalculateProjectUncompleteWorkToStartAfterRequest request) throws ApiException {
        com.squareup.okhttp.Call call = putRecalculateProjectUncompleteWorkToStartAfterValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Recalculate project uncomplete work (asynchronously)
     * 
     * @param request PutRecalculateProjectUncompleteWorkToStartAfter request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call putRecalculateProjectUncompleteWorkToStartAfterAsync(PutRecalculateProjectUncompleteWorkToStartAfterRequest request, final ApiCallback<AsposeResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = putRecalculateProjectUncompleteWorkToStartAfterValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for putRecalculateProjectWorkAsComplete
     * @param request PutRecalculateProjectWorkAsComplete request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call putRecalculateProjectWorkAsCompleteCall(PutRecalculateProjectWorkAsCompleteRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getcompleteThrough();

        // create path and map variables
        String localVarPath = "/tasks/{name}/recalculate/projectWorkAsComplete"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "setZeroOrHundredPercentCompleteOnly", request.getsetZeroOrHundredPercentCompleteOnly());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fileName", request.getfileName());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call putRecalculateProjectWorkAsCompleteValidateBeforeCall(PutRecalculateProjectWorkAsCompleteRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling putRecalculateProjectWorkAsComplete");
        }
        
        // verify the required parameter 'completeThrough' is set
        if (request.getcompleteThrough() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'completeThrough' when calling putRecalculateProjectWorkAsComplete");
        }
        

        com.squareup.okhttp.Call call = putRecalculateProjectWorkAsCompleteCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Recalculate project work as complete 
     * 
     * request PutRecalculateProjectWorkAsComplete request with main agrs
     * @return AsposeResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AsposeResponse putRecalculateProjectWorkAsComplete(PutRecalculateProjectWorkAsCompleteRequest request) throws ApiException {
        try {
            ApiResponse<AsposeResponse> resp = putRecalculateProjectWorkAsCompleteWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<AsposeResponse> resp = putRecalculateProjectWorkAsCompleteWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Recalculate project work as complete 
     * 
     * @param request PutRecalculateProjectWorkAsComplete request with main agrs
     * @return ApiResponse&lt;AsposeResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<AsposeResponse> putRecalculateProjectWorkAsCompleteWithHttpInfo(PutRecalculateProjectWorkAsCompleteRequest request) throws ApiException {
        com.squareup.okhttp.Call call = putRecalculateProjectWorkAsCompleteValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Recalculate project work as complete  (asynchronously)
     * 
     * @param request PutRecalculateProjectWorkAsComplete request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call putRecalculateProjectWorkAsCompleteAsync(PutRecalculateProjectWorkAsCompleteRequest request, final ApiCallback<AsposeResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = putRecalculateProjectWorkAsCompleteValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getReportPdf
     * @param request GetReportPdf request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getReportPdfCall(GetReportPdfRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/report"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "type", request.gettype());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getReportPdfValidateBeforeCall(GetReportPdfRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling getReportPdf");
        }
        
        // verify the required parameter 'type' is set
        if (request.gettype() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'type' when calling getReportPdf");
        }
        

        com.squareup.okhttp.Call call = getReportPdfCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Returns created report in PDF format.
     * 
     * request GetReportPdf request with main agrs
     * @return File
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public File getReportPdf(GetReportPdfRequest request) throws ApiException {
        try {
            ApiResponse<File> resp = getReportPdfWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<File> resp = getReportPdfWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Returns created report in PDF format.
     * 
     * @param request GetReportPdf request with main agrs
     * @return ApiResponse&lt;File&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<File> getReportPdfWithHttpInfo(GetReportPdfRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getReportPdfValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<File>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Returns created report in PDF format. (asynchronously)
     * 
     * @param request GetReportPdf request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getReportPdfAsync(GetReportPdfRequest request, final ApiCallback<File> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getReportPdfValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<File>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for clearLeveling
     * @param request ClearLeveling request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call clearLevelingCall(ClearLevelingRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.gettaskUids();

        // create path and map variables
        String localVarPath = "/tasks/{name}/resourceLevel"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fileName", request.getfileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call clearLevelingValidateBeforeCall(ClearLevelingRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling clearLeveling");
        }
        

        com.squareup.okhttp.Call call = clearLevelingCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Clears leveling delays that was previously added to the project during resource leveling.  If request body is empty, all leveling delays will be cleared.
     * 
     * request ClearLeveling request with main agrs
     * @return AsposeResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AsposeResponse clearLeveling(ClearLevelingRequest request) throws ApiException {
        try {
            ApiResponse<AsposeResponse> resp = clearLevelingWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<AsposeResponse> resp = clearLevelingWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Clears leveling delays that was previously added to the project during resource leveling.  If request body is empty, all leveling delays will be cleared.
     * 
     * @param request ClearLeveling request with main agrs
     * @return ApiResponse&lt;AsposeResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<AsposeResponse> clearLevelingWithHttpInfo(ClearLevelingRequest request) throws ApiException {
        com.squareup.okhttp.Call call = clearLevelingValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Clears leveling delays that was previously added to the project during resource leveling.  If request body is empty, all leveling delays will be cleared. (asynchronously)
     * 
     * @param request ClearLeveling request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call clearLevelingAsync(ClearLevelingRequest request, final ApiCallback<AsposeResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = clearLevelingValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for levelTasks
     * @param request LevelTasks request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call levelTasksCall(LevelTasksRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getoptions();

        // create path and map variables
        String localVarPath = "/tasks/{name}/resourceLevel"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fileName", request.getfileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call levelTasksValidateBeforeCall(LevelTasksRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling levelTasks");
        }
        

        com.squareup.okhttp.Call call = levelTasksCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Levels tasks for project’s resources. If request body is empty,  all project&#39;s resources with default leveling options will be leveled.
     * 
     * request LevelTasks request with main agrs
     * @return LevelingResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public LevelingResponse levelTasks(LevelTasksRequest request) throws ApiException {
        try {
            ApiResponse<LevelingResponse> resp = levelTasksWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<LevelingResponse> resp = levelTasksWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Levels tasks for project’s resources. If request body is empty,  all project&#39;s resources with default leveling options will be leveled.
     * 
     * @param request LevelTasks request with main agrs
     * @return ApiResponse&lt;LevelingResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<LevelingResponse> levelTasksWithHttpInfo(LevelTasksRequest request) throws ApiException {
        com.squareup.okhttp.Call call = levelTasksValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<LevelingResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Levels tasks for project’s resources. If request body is empty,  all project&#39;s resources with default leveling options will be leveled. (asynchronously)
     * 
     * @param request LevelTasks request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call levelTasksAsync(LevelTasksRequest request, final ApiCallback<LevelingResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = levelTasksValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<LevelingResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for deleteResource
     * @param request DeleteResource request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call deleteResourceCall(DeleteResourceRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/resources/{resourceUid}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()))
            .replaceAll("\\{" + "resourceUid" + "\\}", apiClient.escapeString(request.getresourceUid().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fileName", request.getfileName());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteResourceValidateBeforeCall(DeleteResourceRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling deleteResource");
        }
        
        // verify the required parameter 'resourceUid' is set
        if (request.getresourceUid() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'resourceUid' when calling deleteResource");
        }
        

        com.squareup.okhttp.Call call = deleteResourceCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Deletes a project resource with all references to it
     * 
     * request DeleteResource request with main agrs
     * @return AsposeResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AsposeResponse deleteResource(DeleteResourceRequest request) throws ApiException {
        try {
            ApiResponse<AsposeResponse> resp = deleteResourceWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<AsposeResponse> resp = deleteResourceWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Deletes a project resource with all references to it
     * 
     * @param request DeleteResource request with main agrs
     * @return ApiResponse&lt;AsposeResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<AsposeResponse> deleteResourceWithHttpInfo(DeleteResourceRequest request) throws ApiException {
        com.squareup.okhttp.Call call = deleteResourceValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Deletes a project resource with all references to it (asynchronously)
     * 
     * @param request DeleteResource request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteResourceAsync(DeleteResourceRequest request, final ApiCallback<AsposeResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteResourceValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getResource
     * @param request GetResource request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getResourceCall(GetResourceRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/resources/{resourceUid}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()))
            .replaceAll("\\{" + "resourceUid" + "\\}", apiClient.escapeString(request.getresourceUid().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getResourceValidateBeforeCall(GetResourceRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling getResource");
        }
        
        // verify the required parameter 'resourceUid' is set
        if (request.getresourceUid() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'resourceUid' when calling getResource");
        }
        

        com.squareup.okhttp.Call call = getResourceCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get project resource.
     * 
     * request GetResource request with main agrs
     * @return ResourceResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ResourceResponse getResource(GetResourceRequest request) throws ApiException {
        try {
            ApiResponse<ResourceResponse> resp = getResourceWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<ResourceResponse> resp = getResourceWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Get project resource.
     * 
     * @param request GetResource request with main agrs
     * @return ApiResponse&lt;ResourceResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<ResourceResponse> getResourceWithHttpInfo(GetResourceRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getResourceValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<ResourceResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get project resource. (asynchronously)
     * 
     * @param request GetResource request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getResourceAsync(GetResourceRequest request, final ApiCallback<ResourceResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getResourceValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ResourceResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getResourceAssignments
     * @param request GetResourceAssignments request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getResourceAssignmentsCall(GetResourceAssignmentsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/resources/{resourceUid}/assignments"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()))
            .replaceAll("\\{" + "resourceUid" + "\\}", apiClient.escapeString(request.getresourceUid().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getResourceAssignmentsValidateBeforeCall(GetResourceAssignmentsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling getResourceAssignments");
        }
        
        // verify the required parameter 'resourceUid' is set
        if (request.getresourceUid() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'resourceUid' when calling getResourceAssignments");
        }
        

        com.squareup.okhttp.Call call = getResourceAssignmentsCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get resource&#39;s assignments.
     * 
     * request GetResourceAssignments request with main agrs
     * @return AssignmentsResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AssignmentsResponse getResourceAssignments(GetResourceAssignmentsRequest request) throws ApiException {
        try {
            ApiResponse<AssignmentsResponse> resp = getResourceAssignmentsWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<AssignmentsResponse> resp = getResourceAssignmentsWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Get resource&#39;s assignments.
     * 
     * @param request GetResourceAssignments request with main agrs
     * @return ApiResponse&lt;AssignmentsResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<AssignmentsResponse> getResourceAssignmentsWithHttpInfo(GetResourceAssignmentsRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getResourceAssignmentsValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<AssignmentsResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get resource&#39;s assignments. (asynchronously)
     * 
     * @param request GetResourceAssignments request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getResourceAssignmentsAsync(GetResourceAssignmentsRequest request, final ApiCallback<AssignmentsResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getResourceAssignmentsValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AssignmentsResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getResourceTimephasedData
     * @param request GetResourceTimephasedData request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getResourceTimephasedDataCall(GetResourceTimephasedDataRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/resources/{resourceUid}/timeScaleData"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()))
            .replaceAll("\\{" + "resourceUid" + "\\}", apiClient.escapeString(request.getresourceUid().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "type", request.gettype());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "startDate", request.getstartDate());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "endDate", request.getendDate());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getResourceTimephasedDataValidateBeforeCall(GetResourceTimephasedDataRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling getResourceTimephasedData");
        }
        
        // verify the required parameter 'resourceUid' is set
        if (request.getresourceUid() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'resourceUid' when calling getResourceTimephasedData");
        }
        

        com.squareup.okhttp.Call call = getResourceTimephasedDataCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get timescaled data for a resource with the specified Uid.
     * 
     * request GetResourceTimephasedData request with main agrs
     * @return TimephasedDataResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public TimephasedDataResponse getResourceTimephasedData(GetResourceTimephasedDataRequest request) throws ApiException {
        try {
            ApiResponse<TimephasedDataResponse> resp = getResourceTimephasedDataWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<TimephasedDataResponse> resp = getResourceTimephasedDataWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Get timescaled data for a resource with the specified Uid.
     * 
     * @param request GetResourceTimephasedData request with main agrs
     * @return ApiResponse&lt;TimephasedDataResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<TimephasedDataResponse> getResourceTimephasedDataWithHttpInfo(GetResourceTimephasedDataRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getResourceTimephasedDataValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<TimephasedDataResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get timescaled data for a resource with the specified Uid. (asynchronously)
     * 
     * @param request GetResourceTimephasedData request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getResourceTimephasedDataAsync(GetResourceTimephasedDataRequest request, final ApiCallback<TimephasedDataResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getResourceTimephasedDataValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<TimephasedDataResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getResources
     * @param request GetResources request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getResourcesCall(GetResourcesRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/resources"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getResourcesValidateBeforeCall(GetResourcesRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling getResources");
        }
        

        com.squareup.okhttp.Call call = getResourcesCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get a project&#39;s resources.
     * 
     * request GetResources request with main agrs
     * @return ResourceItemsResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ResourceItemsResponse getResources(GetResourcesRequest request) throws ApiException {
        try {
            ApiResponse<ResourceItemsResponse> resp = getResourcesWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<ResourceItemsResponse> resp = getResourcesWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Get a project&#39;s resources.
     * 
     * @param request GetResources request with main agrs
     * @return ApiResponse&lt;ResourceItemsResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<ResourceItemsResponse> getResourcesWithHttpInfo(GetResourcesRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getResourcesValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<ResourceItemsResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get a project&#39;s resources. (asynchronously)
     * 
     * @param request GetResources request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getResourcesAsync(GetResourcesRequest request, final ApiCallback<ResourceItemsResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getResourcesValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ResourceItemsResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for postResource
     * @param request PostResource request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call postResourceCall(PostResourceRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/resources"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "resourceName", request.getresourceName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "beforeResourceId", request.getbeforeResourceId());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fileName", request.getfileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call postResourceValidateBeforeCall(PostResourceRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling postResource");
        }
        

        com.squareup.okhttp.Call call = postResourceCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Add a new resource to a project.
     * 
     * request PostResource request with main agrs
     * @return ResourceItemResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ResourceItemResponse postResource(PostResourceRequest request) throws ApiException {
        try {
            ApiResponse<ResourceItemResponse> resp = postResourceWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<ResourceItemResponse> resp = postResourceWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Add a new resource to a project.
     * 
     * @param request PostResource request with main agrs
     * @return ApiResponse&lt;ResourceItemResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<ResourceItemResponse> postResourceWithHttpInfo(PostResourceRequest request) throws ApiException {
        com.squareup.okhttp.Call call = postResourceValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<ResourceItemResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Add a new resource to a project. (asynchronously)
     * 
     * @param request PostResource request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call postResourceAsync(PostResourceRequest request, final ApiCallback<ResourceItemResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = postResourceValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ResourceItemResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for putResource
     * @param request PutResource request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call putResourceCall(PutResourceRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getresource();

        // create path and map variables
        String localVarPath = "/tasks/{name}/resources/{resourceUid}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()))
            .replaceAll("\\{" + "resourceUid" + "\\}", apiClient.escapeString(request.getresourceUid().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "mode", request.getmode());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "recalculate", request.getrecalculate());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fileName", request.getfileName());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call putResourceValidateBeforeCall(PutResourceRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling putResource");
        }
        
        // verify the required parameter 'resourceUid' is set
        if (request.getresourceUid() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'resourceUid' when calling putResource");
        }
        
        // verify the required parameter 'resource' is set
        if (request.getresource() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'resource' when calling putResource");
        }
        

        com.squareup.okhttp.Call call = putResourceCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Updates resource with the specified Uid
     * 
     * request PutResource request with main agrs
     * @return ResourceResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ResourceResponse putResource(PutResourceRequest request) throws ApiException {
        try {
            ApiResponse<ResourceResponse> resp = putResourceWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<ResourceResponse> resp = putResourceWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Updates resource with the specified Uid
     * 
     * @param request PutResource request with main agrs
     * @return ApiResponse&lt;ResourceResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<ResourceResponse> putResourceWithHttpInfo(PutResourceRequest request) throws ApiException {
        com.squareup.okhttp.Call call = putResourceValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<ResourceResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Updates resource with the specified Uid (asynchronously)
     * 
     * @param request PutResource request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call putResourceAsync(PutResourceRequest request, final ApiCallback<ResourceResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = putResourceValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ResourceResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getRiskAnalysisReport
     * @param request GetRiskAnalysisReport request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getRiskAnalysisReportCall(GetRiskAnalysisReportRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/riskAnalysisReport"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "taskUid", request.gettaskUid());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "distributionType", request.getdistributionType());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "optimistic", request.getoptimistic());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "pessimistic", request.getpessimistic());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "confidenceLevel", request.getconfidenceLevel());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "iterations", request.getiterations());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fileName", request.getfileName());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "multipart/form-data"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getRiskAnalysisReportValidateBeforeCall(GetRiskAnalysisReportRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling getRiskAnalysisReport");
        }
        
        // verify the required parameter 'taskUid' is set
        if (request.gettaskUid() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'taskUid' when calling getRiskAnalysisReport");
        }
        

        com.squareup.okhttp.Call call = getRiskAnalysisReportCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Performs a risk analysys using Monte Carlo simulation and creates a risk analysis report.
     * 
     * request GetRiskAnalysisReport request with main agrs
     * @return File
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public File getRiskAnalysisReport(GetRiskAnalysisReportRequest request) throws ApiException {
        try {
            ApiResponse<File> resp = getRiskAnalysisReportWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<File> resp = getRiskAnalysisReportWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Performs a risk analysys using Monte Carlo simulation and creates a risk analysis report.
     * 
     * @param request GetRiskAnalysisReport request with main agrs
     * @return ApiResponse&lt;File&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<File> getRiskAnalysisReportWithHttpInfo(GetRiskAnalysisReportRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getRiskAnalysisReportValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<File>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Performs a risk analysys using Monte Carlo simulation and creates a risk analysis report. (asynchronously)
     * 
     * @param request GetRiskAnalysisReport request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getRiskAnalysisReportAsync(GetRiskAnalysisReportRequest request, final ApiCallback<File> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getRiskAnalysisReportValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<File>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for deleteTask
     * @param request DeleteTask request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call deleteTaskCall(DeleteTaskRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/tasks/{taskUid}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()))
            .replaceAll("\\{" + "taskUid" + "\\}", apiClient.escapeString(request.gettaskUid().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fileName", request.getfileName());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteTaskValidateBeforeCall(DeleteTaskRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling deleteTask");
        }
        
        // verify the required parameter 'taskUid' is set
        if (request.gettaskUid() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'taskUid' when calling deleteTask");
        }
        

        com.squareup.okhttp.Call call = deleteTaskCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Deletes a project task with all references to it and rebuilds tasks tree.
     * 
     * request DeleteTask request with main agrs
     * @return AsposeResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AsposeResponse deleteTask(DeleteTaskRequest request) throws ApiException {
        try {
            ApiResponse<AsposeResponse> resp = deleteTaskWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<AsposeResponse> resp = deleteTaskWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Deletes a project task with all references to it and rebuilds tasks tree.
     * 
     * @param request DeleteTask request with main agrs
     * @return ApiResponse&lt;AsposeResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<AsposeResponse> deleteTaskWithHttpInfo(DeleteTaskRequest request) throws ApiException {
        com.squareup.okhttp.Call call = deleteTaskValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Deletes a project task with all references to it and rebuilds tasks tree. (asynchronously)
     * 
     * @param request DeleteTask request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteTaskAsync(DeleteTaskRequest request, final ApiCallback<AsposeResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteTaskValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getPrimaveraTaskProperties
     * @param request GetPrimaveraTaskProperties request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getPrimaveraTaskPropertiesCall(GetPrimaveraTaskPropertiesRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/tasks/{taskUid}/primaveraProperties"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()))
            .replaceAll("\\{" + "taskUid" + "\\}", apiClient.escapeString(request.gettaskUid().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getPrimaveraTaskPropertiesValidateBeforeCall(GetPrimaveraTaskPropertiesRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling getPrimaveraTaskProperties");
        }
        
        // verify the required parameter 'taskUid' is set
        if (request.gettaskUid() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'taskUid' when calling getPrimaveraTaskProperties");
        }
        

        com.squareup.okhttp.Call call = getPrimaveraTaskPropertiesCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get primavera properties for a task with the specified Uid.
     * 
     * request GetPrimaveraTaskProperties request with main agrs
     * @return PrimaveraTaskPropertiesResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public PrimaveraTaskPropertiesResponse getPrimaveraTaskProperties(GetPrimaveraTaskPropertiesRequest request) throws ApiException {
        try {
            ApiResponse<PrimaveraTaskPropertiesResponse> resp = getPrimaveraTaskPropertiesWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<PrimaveraTaskPropertiesResponse> resp = getPrimaveraTaskPropertiesWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Get primavera properties for a task with the specified Uid.
     * 
     * @param request GetPrimaveraTaskProperties request with main agrs
     * @return ApiResponse&lt;PrimaveraTaskPropertiesResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<PrimaveraTaskPropertiesResponse> getPrimaveraTaskPropertiesWithHttpInfo(GetPrimaveraTaskPropertiesRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getPrimaveraTaskPropertiesValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<PrimaveraTaskPropertiesResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get primavera properties for a task with the specified Uid. (asynchronously)
     * 
     * @param request GetPrimaveraTaskProperties request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getPrimaveraTaskPropertiesAsync(GetPrimaveraTaskPropertiesRequest request, final ApiCallback<PrimaveraTaskPropertiesResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getPrimaveraTaskPropertiesValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<PrimaveraTaskPropertiesResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getTask
     * @param request GetTask request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getTaskCall(GetTaskRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/tasks/{taskUid}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()))
            .replaceAll("\\{" + "taskUid" + "\\}", apiClient.escapeString(request.gettaskUid().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getTaskValidateBeforeCall(GetTaskRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling getTask");
        }
        
        // verify the required parameter 'taskUid' is set
        if (request.gettaskUid() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'taskUid' when calling getTask");
        }
        

        com.squareup.okhttp.Call call = getTaskCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Read project task.
     * 
     * request GetTask request with main agrs
     * @return TaskResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public TaskResponse getTask(GetTaskRequest request) throws ApiException {
        try {
            ApiResponse<TaskResponse> resp = getTaskWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<TaskResponse> resp = getTaskWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Read project task.
     * 
     * @param request GetTask request with main agrs
     * @return ApiResponse&lt;TaskResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<TaskResponse> getTaskWithHttpInfo(GetTaskRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getTaskValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<TaskResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Read project task. (asynchronously)
     * 
     * @param request GetTask request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getTaskAsync(GetTaskRequest request, final ApiCallback<TaskResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getTaskValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<TaskResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getTaskAssignments
     * @param request GetTaskAssignments request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getTaskAssignmentsCall(GetTaskAssignmentsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/tasks/{taskUid}/assignments"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()))
            .replaceAll("\\{" + "taskUid" + "\\}", apiClient.escapeString(request.gettaskUid().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getTaskAssignmentsValidateBeforeCall(GetTaskAssignmentsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling getTaskAssignments");
        }
        
        // verify the required parameter 'taskUid' is set
        if (request.gettaskUid() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'taskUid' when calling getTaskAssignments");
        }
        

        com.squareup.okhttp.Call call = getTaskAssignmentsCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get task assignments.
     * 
     * request GetTaskAssignments request with main agrs
     * @return AssignmentsResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AssignmentsResponse getTaskAssignments(GetTaskAssignmentsRequest request) throws ApiException {
        try {
            ApiResponse<AssignmentsResponse> resp = getTaskAssignmentsWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<AssignmentsResponse> resp = getTaskAssignmentsWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Get task assignments.
     * 
     * @param request GetTaskAssignments request with main agrs
     * @return ApiResponse&lt;AssignmentsResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<AssignmentsResponse> getTaskAssignmentsWithHttpInfo(GetTaskAssignmentsRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getTaskAssignmentsValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<AssignmentsResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get task assignments. (asynchronously)
     * 
     * @param request GetTaskAssignments request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getTaskAssignmentsAsync(GetTaskAssignmentsRequest request, final ApiCallback<AssignmentsResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getTaskAssignmentsValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AssignmentsResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getTaskRecurringInfo
     * @param request GetTaskRecurringInfo request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getTaskRecurringInfoCall(GetTaskRecurringInfoRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/tasks/{taskUid}/recurringInfo"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()))
            .replaceAll("\\{" + "taskUid" + "\\}", apiClient.escapeString(request.gettaskUid().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getTaskRecurringInfoValidateBeforeCall(GetTaskRecurringInfoRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling getTaskRecurringInfo");
        }
        
        // verify the required parameter 'taskUid' is set
        if (request.gettaskUid() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'taskUid' when calling getTaskRecurringInfo");
        }
        

        com.squareup.okhttp.Call call = getTaskRecurringInfoCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get recurring info for a task with the specified Uid
     * 
     * request GetTaskRecurringInfo request with main agrs
     * @return RecurringInfoResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public RecurringInfoResponse getTaskRecurringInfo(GetTaskRecurringInfoRequest request) throws ApiException {
        try {
            ApiResponse<RecurringInfoResponse> resp = getTaskRecurringInfoWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<RecurringInfoResponse> resp = getTaskRecurringInfoWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Get recurring info for a task with the specified Uid
     * 
     * @param request GetTaskRecurringInfo request with main agrs
     * @return ApiResponse&lt;RecurringInfoResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<RecurringInfoResponse> getTaskRecurringInfoWithHttpInfo(GetTaskRecurringInfoRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getTaskRecurringInfoValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<RecurringInfoResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get recurring info for a task with the specified Uid (asynchronously)
     * 
     * @param request GetTaskRecurringInfo request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getTaskRecurringInfoAsync(GetTaskRecurringInfoRequest request, final ApiCallback<RecurringInfoResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getTaskRecurringInfoValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<RecurringInfoResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getTaskTimephasedData
     * @param request GetTaskTimephasedData request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getTaskTimephasedDataCall(GetTaskTimephasedDataRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/tasks/{taskUid}/timeScaleData"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()))
            .replaceAll("\\{" + "taskUid" + "\\}", apiClient.escapeString(request.gettaskUid().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "type", request.gettype());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "startDate", request.getstartDate());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "endDate", request.getendDate());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getTaskTimephasedDataValidateBeforeCall(GetTaskTimephasedDataRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling getTaskTimephasedData");
        }
        
        // verify the required parameter 'taskUid' is set
        if (request.gettaskUid() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'taskUid' when calling getTaskTimephasedData");
        }
        

        com.squareup.okhttp.Call call = getTaskTimephasedDataCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get timescaled data for a task with the specified Uid.
     * 
     * request GetTaskTimephasedData request with main agrs
     * @return TimephasedDataResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public TimephasedDataResponse getTaskTimephasedData(GetTaskTimephasedDataRequest request) throws ApiException {
        try {
            ApiResponse<TimephasedDataResponse> resp = getTaskTimephasedDataWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<TimephasedDataResponse> resp = getTaskTimephasedDataWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Get timescaled data for a task with the specified Uid.
     * 
     * @param request GetTaskTimephasedData request with main agrs
     * @return ApiResponse&lt;TimephasedDataResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<TimephasedDataResponse> getTaskTimephasedDataWithHttpInfo(GetTaskTimephasedDataRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getTaskTimephasedDataValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<TimephasedDataResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get timescaled data for a task with the specified Uid. (asynchronously)
     * 
     * @param request GetTaskTimephasedData request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getTaskTimephasedDataAsync(GetTaskTimephasedDataRequest request, final ApiCallback<TimephasedDataResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getTaskTimephasedDataValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<TimephasedDataResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getTasks
     * @param request GetTasks request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getTasksCall(GetTasksRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/tasks"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getTasksValidateBeforeCall(GetTasksRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling getTasks");
        }
        

        com.squareup.okhttp.Call call = getTasksCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get a project&#39;s tasks.
     * 
     * request GetTasks request with main agrs
     * @return TaskItemsResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public TaskItemsResponse getTasks(GetTasksRequest request) throws ApiException {
        try {
            ApiResponse<TaskItemsResponse> resp = getTasksWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<TaskItemsResponse> resp = getTasksWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Get a project&#39;s tasks.
     * 
     * @param request GetTasks request with main agrs
     * @return ApiResponse&lt;TaskItemsResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<TaskItemsResponse> getTasksWithHttpInfo(GetTasksRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getTasksValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<TaskItemsResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get a project&#39;s tasks. (asynchronously)
     * 
     * @param request GetTasks request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getTasksAsync(GetTasksRequest request, final ApiCallback<TaskItemsResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getTasksValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<TaskItemsResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for postTask
     * @param request PostTask request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call postTaskCall(PostTaskRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/tasks"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "taskName", request.gettaskName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "beforeTaskId", request.getbeforeTaskId());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fileName", request.getfileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call postTaskValidateBeforeCall(PostTaskRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling postTask");
        }
        

        com.squareup.okhttp.Call call = postTaskCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Add a new task to a project.
     * 
     * request PostTask request with main agrs
     * @return TaskItemResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public TaskItemResponse postTask(PostTaskRequest request) throws ApiException {
        try {
            ApiResponse<TaskItemResponse> resp = postTaskWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<TaskItemResponse> resp = postTaskWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Add a new task to a project.
     * 
     * @param request PostTask request with main agrs
     * @return ApiResponse&lt;TaskItemResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<TaskItemResponse> postTaskWithHttpInfo(PostTaskRequest request) throws ApiException {
        com.squareup.okhttp.Call call = postTaskValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<TaskItemResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Add a new task to a project. (asynchronously)
     * 
     * @param request PostTask request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call postTaskAsync(PostTaskRequest request, final ApiCallback<TaskItemResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = postTaskValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<TaskItemResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for postTaskRecurringInfo
     * @param request PostTaskRecurringInfo request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call postTaskRecurringInfoCall(PostTaskRecurringInfoRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getrecurringInfo();

        // create path and map variables
        String localVarPath = "/tasks/{name}/tasks/recurringInfo"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "parentTaskUid", request.getparentTaskUid());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "taskName", request.gettaskName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "calendarName", request.getcalendarName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fileName", request.getfileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call postTaskRecurringInfoValidateBeforeCall(PostTaskRecurringInfoRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling postTaskRecurringInfo");
        }
        
        // verify the required parameter 'parentTaskUid' is set
        if (request.getparentTaskUid() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'parentTaskUid' when calling postTaskRecurringInfo");
        }
        
        // verify the required parameter 'taskName' is set
        if (request.gettaskName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'taskName' when calling postTaskRecurringInfo");
        }
        
        // verify the required parameter 'recurringInfo' is set
        if (request.getrecurringInfo() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'recurringInfo' when calling postTaskRecurringInfo");
        }
        
        // verify the required parameter 'calendarName' is set
        if (request.getcalendarName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'calendarName' when calling postTaskRecurringInfo");
        }
        

        com.squareup.okhttp.Call call = postTaskRecurringInfoCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Adds a new recurring task.
     * 
     * request PostTaskRecurringInfo request with main agrs
     * @return TaskItemResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public TaskItemResponse postTaskRecurringInfo(PostTaskRecurringInfoRequest request) throws ApiException {
        try {
            ApiResponse<TaskItemResponse> resp = postTaskRecurringInfoWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<TaskItemResponse> resp = postTaskRecurringInfoWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Adds a new recurring task.
     * 
     * @param request PostTaskRecurringInfo request with main agrs
     * @return ApiResponse&lt;TaskItemResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<TaskItemResponse> postTaskRecurringInfoWithHttpInfo(PostTaskRecurringInfoRequest request) throws ApiException {
        com.squareup.okhttp.Call call = postTaskRecurringInfoValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<TaskItemResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Adds a new recurring task. (asynchronously)
     * 
     * @param request PostTaskRecurringInfo request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call postTaskRecurringInfoAsync(PostTaskRecurringInfoRequest request, final ApiCallback<TaskItemResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = postTaskRecurringInfoValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<TaskItemResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for postTasks
     * @param request PostTasks request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call postTasksCall(PostTasksRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getrequests();

        // create path and map variables
        String localVarPath = "/tasks/{name}/tasks/batch"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fileName", request.getfileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call postTasksValidateBeforeCall(PostTasksRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling postTasks");
        }
        
        // verify the required parameter 'requests' is set
        if (request.getrequests() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'requests' when calling postTasks");
        }
        

        com.squareup.okhttp.Call call = postTasksCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Create multiple tasks by single request.
     * 
     * request PostTasks request with main agrs
     * @return TaskItemsResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public TaskItemsResponse postTasks(PostTasksRequest request) throws ApiException {
        try {
            ApiResponse<TaskItemsResponse> resp = postTasksWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<TaskItemsResponse> resp = postTasksWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Create multiple tasks by single request.
     * 
     * @param request PostTasks request with main agrs
     * @return ApiResponse&lt;TaskItemsResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<TaskItemsResponse> postTasksWithHttpInfo(PostTasksRequest request) throws ApiException {
        com.squareup.okhttp.Call call = postTasksValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<TaskItemsResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create multiple tasks by single request. (asynchronously)
     * 
     * @param request PostTasks request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call postTasksAsync(PostTasksRequest request, final ApiCallback<TaskItemsResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = postTasksValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<TaskItemsResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for putMoveTask
     * @param request PutMoveTask request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call putMoveTaskCall(PutMoveTaskRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/tasks/{taskUid}/move"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()))
            .replaceAll("\\{" + "taskUid" + "\\}", apiClient.escapeString(request.gettaskUid().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "parentTaskUid", request.getparentTaskUid());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fileName", request.getfileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call putMoveTaskValidateBeforeCall(PutMoveTaskRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling putMoveTask");
        }
        
        // verify the required parameter 'taskUid' is set
        if (request.gettaskUid() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'taskUid' when calling putMoveTask");
        }
        
        // verify the required parameter 'parentTaskUid' is set
        if (request.getparentTaskUid() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'parentTaskUid' when calling putMoveTask");
        }
        

        com.squareup.okhttp.Call call = putMoveTaskCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Move one task to another parent task.
     * 
     * request PutMoveTask request with main agrs
     * @return AsposeResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AsposeResponse putMoveTask(PutMoveTaskRequest request) throws ApiException {
        try {
            ApiResponse<AsposeResponse> resp = putMoveTaskWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<AsposeResponse> resp = putMoveTaskWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Move one task to another parent task.
     * 
     * @param request PutMoveTask request with main agrs
     * @return ApiResponse&lt;AsposeResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<AsposeResponse> putMoveTaskWithHttpInfo(PutMoveTaskRequest request) throws ApiException {
        com.squareup.okhttp.Call call = putMoveTaskValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Move one task to another parent task. (asynchronously)
     * 
     * @param request PutMoveTask request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call putMoveTaskAsync(PutMoveTaskRequest request, final ApiCallback<AsposeResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = putMoveTaskValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for putMoveTaskToSibling
     * @param request PutMoveTaskToSibling request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call putMoveTaskToSiblingCall(PutMoveTaskToSiblingRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/tasks/{taskUid}/moveToSibling"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()))
            .replaceAll("\\{" + "taskUid" + "\\}", apiClient.escapeString(request.gettaskUid().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "beforeTaskUid", request.getbeforeTaskUid());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fileName", request.getfileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call putMoveTaskToSiblingValidateBeforeCall(PutMoveTaskToSiblingRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling putMoveTaskToSibling");
        }
        
        // verify the required parameter 'taskUid' is set
        if (request.gettaskUid() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'taskUid' when calling putMoveTaskToSibling");
        }
        
        // verify the required parameter 'beforeTaskUid' is set
        if (request.getbeforeTaskUid() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'beforeTaskUid' when calling putMoveTaskToSibling");
        }
        

        com.squareup.okhttp.Call call = putMoveTaskToSiblingCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Move a task to another position under the same parent and the same outline level
     * 
     * request PutMoveTaskToSibling request with main agrs
     * @return AsposeResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AsposeResponse putMoveTaskToSibling(PutMoveTaskToSiblingRequest request) throws ApiException {
        try {
            ApiResponse<AsposeResponse> resp = putMoveTaskToSiblingWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<AsposeResponse> resp = putMoveTaskToSiblingWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Move a task to another position under the same parent and the same outline level
     * 
     * @param request PutMoveTaskToSibling request with main agrs
     * @return ApiResponse&lt;AsposeResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<AsposeResponse> putMoveTaskToSiblingWithHttpInfo(PutMoveTaskToSiblingRequest request) throws ApiException {
        com.squareup.okhttp.Call call = putMoveTaskToSiblingValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Move a task to another position under the same parent and the same outline level (asynchronously)
     * 
     * @param request PutMoveTaskToSibling request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call putMoveTaskToSiblingAsync(PutMoveTaskToSiblingRequest request, final ApiCallback<AsposeResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = putMoveTaskToSiblingValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for putTask
     * @param request PutTask request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call putTaskCall(PutTaskRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.gettask();

        // create path and map variables
        String localVarPath = "/tasks/{name}/tasks/{taskUid}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()))
            .replaceAll("\\{" + "taskUid" + "\\}", apiClient.escapeString(request.gettaskUid().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "mode", request.getmode());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "recalculate", request.getrecalculate());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fileName", request.getfileName());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call putTaskValidateBeforeCall(PutTaskRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling putTask");
        }
        
        // verify the required parameter 'taskUid' is set
        if (request.gettaskUid() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'taskUid' when calling putTask");
        }
        
        // verify the required parameter 'task' is set
        if (request.gettask() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'task' when calling putTask");
        }
        

        com.squareup.okhttp.Call call = putTaskCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Updates special task getting by task UID
     * 
     * request PutTask request with main agrs
     * @return TaskResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public TaskResponse putTask(PutTaskRequest request) throws ApiException {
        try {
            ApiResponse<TaskResponse> resp = putTaskWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<TaskResponse> resp = putTaskWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Updates special task getting by task UID
     * 
     * @param request PutTask request with main agrs
     * @return ApiResponse&lt;TaskResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<TaskResponse> putTaskWithHttpInfo(PutTaskRequest request) throws ApiException {
        com.squareup.okhttp.Call call = putTaskValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<TaskResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Updates special task getting by task UID (asynchronously)
     * 
     * @param request PutTask request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call putTaskAsync(PutTaskRequest request, final ApiCallback<TaskResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = putTaskValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<TaskResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for putTaskRecurringInfo
     * @param request PutTaskRecurringInfo request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call putTaskRecurringInfoCall(PutTaskRecurringInfoRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getrecurringInfo();

        // create path and map variables
        String localVarPath = "/tasks/{name}/tasks/{taskUid}/recurringInfo"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()))
            .replaceAll("\\{" + "taskUid" + "\\}", apiClient.escapeString(request.gettaskUid().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fileName", request.getfileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call putTaskRecurringInfoValidateBeforeCall(PutTaskRecurringInfoRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling putTaskRecurringInfo");
        }
        
        // verify the required parameter 'taskUid' is set
        if (request.gettaskUid() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'taskUid' when calling putTaskRecurringInfo");
        }
        
        // verify the required parameter 'recurringInfo' is set
        if (request.getrecurringInfo() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'recurringInfo' when calling putTaskRecurringInfo");
        }
        

        com.squareup.okhttp.Call call = putTaskRecurringInfoCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Updates existing task&#39;s recurring info. Note that task should be already recurring.
     * 
     * request PutTaskRecurringInfo request with main agrs
     * @return AsposeResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AsposeResponse putTaskRecurringInfo(PutTaskRecurringInfoRequest request) throws ApiException {
        try {
            ApiResponse<AsposeResponse> resp = putTaskRecurringInfoWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<AsposeResponse> resp = putTaskRecurringInfoWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Updates existing task&#39;s recurring info. Note that task should be already recurring.
     * 
     * @param request PutTaskRecurringInfo request with main agrs
     * @return ApiResponse&lt;AsposeResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<AsposeResponse> putTaskRecurringInfoWithHttpInfo(PutTaskRecurringInfoRequest request) throws ApiException {
        com.squareup.okhttp.Call call = putTaskRecurringInfoValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Updates existing task&#39;s recurring info. Note that task should be already recurring. (asynchronously)
     * 
     * @param request PutTaskRecurringInfo request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call putTaskRecurringInfoAsync(PutTaskRecurringInfoRequest request, final ApiCallback<AsposeResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = putTaskRecurringInfoValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for deleteTaskLink
     * @param request DeleteTaskLink request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call deleteTaskLinkCall(DeleteTaskLinkRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/taskLinks/{index}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getindex().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fileName", request.getfileName());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteTaskLinkValidateBeforeCall(DeleteTaskLinkRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling deleteTaskLink");
        }
        
        // verify the required parameter 'index' is set
        if (request.getindex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'index' when calling deleteTaskLink");
        }
        

        com.squareup.okhttp.Call call = deleteTaskLinkCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Delete task link.
     * 
     * request DeleteTaskLink request with main agrs
     * @return AsposeResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AsposeResponse deleteTaskLink(DeleteTaskLinkRequest request) throws ApiException {
        try {
            ApiResponse<AsposeResponse> resp = deleteTaskLinkWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<AsposeResponse> resp = deleteTaskLinkWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Delete task link.
     * 
     * @param request DeleteTaskLink request with main agrs
     * @return ApiResponse&lt;AsposeResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<AsposeResponse> deleteTaskLinkWithHttpInfo(DeleteTaskLinkRequest request) throws ApiException {
        com.squareup.okhttp.Call call = deleteTaskLinkValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Delete task link. (asynchronously)
     * 
     * @param request DeleteTaskLink request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteTaskLinkAsync(DeleteTaskLinkRequest request, final ApiCallback<AsposeResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteTaskLinkValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getTaskLinks
     * @param request GetTaskLinks request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getTaskLinksCall(GetTaskLinksRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/taskLinks"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getTaskLinksValidateBeforeCall(GetTaskLinksRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling getTaskLinks");
        }
        

        com.squareup.okhttp.Call call = getTaskLinksCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get tasks&#39; links of a project.
     * 
     * request GetTaskLinks request with main agrs
     * @return TaskLinksResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public TaskLinksResponse getTaskLinks(GetTaskLinksRequest request) throws ApiException {
        try {
            ApiResponse<TaskLinksResponse> resp = getTaskLinksWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<TaskLinksResponse> resp = getTaskLinksWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Get tasks&#39; links of a project.
     * 
     * @param request GetTaskLinks request with main agrs
     * @return ApiResponse&lt;TaskLinksResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<TaskLinksResponse> getTaskLinksWithHttpInfo(GetTaskLinksRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getTaskLinksValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<TaskLinksResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get tasks&#39; links of a project. (asynchronously)
     * 
     * @param request GetTaskLinks request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getTaskLinksAsync(GetTaskLinksRequest request, final ApiCallback<TaskLinksResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getTaskLinksValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<TaskLinksResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for postTaskLink
     * @param request PostTaskLink request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call postTaskLinkCall(PostTaskLinkRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.gettaskLink();

        // create path and map variables
        String localVarPath = "/tasks/{name}/taskLinks"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fileName", request.getfileName());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call postTaskLinkValidateBeforeCall(PostTaskLinkRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling postTaskLink");
        }
        
        // verify the required parameter 'taskLink' is set
        if (request.gettaskLink() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'taskLink' when calling postTaskLink");
        }
        

        com.squareup.okhttp.Call call = postTaskLinkCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Adds a new task link to a project.
     * 
     * request PostTaskLink request with main agrs
     * @return AsposeResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AsposeResponse postTaskLink(PostTaskLinkRequest request) throws ApiException {
        try {
            ApiResponse<AsposeResponse> resp = postTaskLinkWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<AsposeResponse> resp = postTaskLinkWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Adds a new task link to a project.
     * 
     * @param request PostTaskLink request with main agrs
     * @return ApiResponse&lt;AsposeResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<AsposeResponse> postTaskLinkWithHttpInfo(PostTaskLinkRequest request) throws ApiException {
        com.squareup.okhttp.Call call = postTaskLinkValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Adds a new task link to a project. (asynchronously)
     * 
     * @param request PostTaskLink request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call postTaskLinkAsync(PostTaskLinkRequest request, final ApiCallback<AsposeResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = postTaskLinkValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for putTaskLink
     * @param request PutTaskLink request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call putTaskLinkCall(PutTaskLinkRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.gettaskLink();

        // create path and map variables
        String localVarPath = "/tasks/{name}/taskLinks/{index}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getindex().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fileName", request.getfileName());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call putTaskLinkValidateBeforeCall(PutTaskLinkRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling putTaskLink");
        }
        
        // verify the required parameter 'index' is set
        if (request.getindex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'index' when calling putTaskLink");
        }
        
        // verify the required parameter 'taskLink' is set
        if (request.gettaskLink() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'taskLink' when calling putTaskLink");
        }
        

        com.squareup.okhttp.Call call = putTaskLinkCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Updates existing task link.
     * 
     * request PutTaskLink request with main agrs
     * @return TaskLinkResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public TaskLinkResponse putTaskLink(PutTaskLinkRequest request) throws ApiException {
        try {
            ApiResponse<TaskLinkResponse> resp = putTaskLinkWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<TaskLinkResponse> resp = putTaskLinkWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Updates existing task link.
     * 
     * @param request PutTaskLink request with main agrs
     * @return ApiResponse&lt;TaskLinkResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<TaskLinkResponse> putTaskLinkWithHttpInfo(PutTaskLinkRequest request) throws ApiException {
        com.squareup.okhttp.Call call = putTaskLinkValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<TaskLinkResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Updates existing task link. (asynchronously)
     * 
     * @param request PutTaskLink request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call putTaskLinkAsync(PutTaskLinkRequest request, final ApiCallback<TaskLinkResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = putTaskLinkValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<TaskLinkResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getVbaProject
     * @param request GetVbaProject request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getVbaProjectCall(GetVbaProjectRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/vbaproject"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getVbaProjectValidateBeforeCall(GetVbaProjectRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling getVbaProject");
        }
        

        com.squareup.okhttp.Call call = getVbaProjectCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Returns VBA project.
     * 
     * request GetVbaProject request with main agrs
     * @return VbaProjectResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public VbaProjectResponse getVbaProject(GetVbaProjectRequest request) throws ApiException {
        try {
            ApiResponse<VbaProjectResponse> resp = getVbaProjectWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<VbaProjectResponse> resp = getVbaProjectWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Returns VBA project.
     * 
     * @param request GetVbaProject request with main agrs
     * @return ApiResponse&lt;VbaProjectResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<VbaProjectResponse> getVbaProjectWithHttpInfo(GetVbaProjectRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getVbaProjectValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<VbaProjectResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Returns VBA project. (asynchronously)
     * 
     * @param request GetVbaProject request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getVbaProjectAsync(GetVbaProjectRequest request, final ApiCallback<VbaProjectResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getVbaProjectValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<VbaProjectResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for createTableTextStyle
     * @param request CreateTableTextStyle request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call createTableTextStyleCall(CreateTableTextStyleRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.gettableTextStyle();

        // create path and map variables
        String localVarPath = "/tasks/{name}/views/{viewUid}/tabletextstyles"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()))
            .replaceAll("\\{" + "viewUid" + "\\}", apiClient.escapeString(request.getviewUid().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fileName", request.getfileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call createTableTextStyleValidateBeforeCall(CreateTableTextStyleRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling createTableTextStyle");
        }
        
        // verify the required parameter 'viewUid' is set
        if (request.getviewUid() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'viewUid' when calling createTableTextStyle");
        }
        
        // verify the required parameter 'tableTextStyle' is set
        if (request.gettableTextStyle() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'tableTextStyle' when calling createTableTextStyle");
        }
        

        com.squareup.okhttp.Call call = createTableTextStyleCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Create table text style in specified view.
     * 
     * request CreateTableTextStyle request with main agrs
     * @return AsposeResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AsposeResponse createTableTextStyle(CreateTableTextStyleRequest request) throws ApiException {
        try {
            ApiResponse<AsposeResponse> resp = createTableTextStyleWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<AsposeResponse> resp = createTableTextStyleWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Create table text style in specified view.
     * 
     * @param request CreateTableTextStyle request with main agrs
     * @return ApiResponse&lt;AsposeResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<AsposeResponse> createTableTextStyleWithHttpInfo(CreateTableTextStyleRequest request) throws ApiException {
        com.squareup.okhttp.Call call = createTableTextStyleValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create table text style in specified view. (asynchronously)
     * 
     * @param request CreateTableTextStyle request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call createTableTextStyleAsync(CreateTableTextStyleRequest request, final ApiCallback<AsposeResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = createTableTextStyleValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for deleteTableTextStyle
     * @param request DeleteTableTextStyle request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call deleteTableTextStyleCall(DeleteTableTextStyleRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/views/{viewUid}/tabletextstyles/{rowUid}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()))
            .replaceAll("\\{" + "viewUid" + "\\}", apiClient.escapeString(request.getviewUid().toString()))
            .replaceAll("\\{" + "rowUid" + "\\}", apiClient.escapeString(request.getrowUid().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "field", request.getfield());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fileName", request.getfileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteTableTextStyleValidateBeforeCall(DeleteTableTextStyleRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling deleteTableTextStyle");
        }
        
        // verify the required parameter 'viewUid' is set
        if (request.getviewUid() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'viewUid' when calling deleteTableTextStyle");
        }
        
        // verify the required parameter 'rowUid' is set
        if (request.getrowUid() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'rowUid' when calling deleteTableTextStyle");
        }
        

        com.squareup.okhttp.Call call = deleteTableTextStyleCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Delete specified table text style from specified view.
     * 
     * request DeleteTableTextStyle request with main agrs
     * @return AsposeResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AsposeResponse deleteTableTextStyle(DeleteTableTextStyleRequest request) throws ApiException {
        try {
            ApiResponse<AsposeResponse> resp = deleteTableTextStyleWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<AsposeResponse> resp = deleteTableTextStyleWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Delete specified table text style from specified view.
     * 
     * @param request DeleteTableTextStyle request with main agrs
     * @return ApiResponse&lt;AsposeResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<AsposeResponse> deleteTableTextStyleWithHttpInfo(DeleteTableTextStyleRequest request) throws ApiException {
        com.squareup.okhttp.Call call = deleteTableTextStyleValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Delete specified table text style from specified view. (asynchronously)
     * 
     * @param request DeleteTableTextStyle request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteTableTextStyleAsync(DeleteTableTextStyleRequest request, final ApiCallback<AsposeResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteTableTextStyleValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getAllTableTextStyles
     * @param request GetAllTableTextStyles request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getAllTableTextStylesCall(GetAllTableTextStylesRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/views/{viewUid}/tabletextstyles"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()))
            .replaceAll("\\{" + "viewUid" + "\\}", apiClient.escapeString(request.getviewUid().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getAllTableTextStylesValidateBeforeCall(GetAllTableTextStylesRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling getAllTableTextStyles");
        }
        
        // verify the required parameter 'viewUid' is set
        if (request.getviewUid() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'viewUid' when calling getAllTableTextStyles");
        }
        

        com.squareup.okhttp.Call call = getAllTableTextStylesCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Read all table text styles from specified view.
     * 
     * request GetAllTableTextStyles request with main agrs
     * @return TableTextStylesResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public TableTextStylesResponse getAllTableTextStyles(GetAllTableTextStylesRequest request) throws ApiException {
        try {
            ApiResponse<TableTextStylesResponse> resp = getAllTableTextStylesWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<TableTextStylesResponse> resp = getAllTableTextStylesWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Read all table text styles from specified view.
     * 
     * @param request GetAllTableTextStyles request with main agrs
     * @return ApiResponse&lt;TableTextStylesResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<TableTextStylesResponse> getAllTableTextStylesWithHttpInfo(GetAllTableTextStylesRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getAllTableTextStylesValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<TableTextStylesResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Read all table text styles from specified view. (asynchronously)
     * 
     * @param request GetAllTableTextStyles request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getAllTableTextStylesAsync(GetAllTableTextStylesRequest request, final ApiCallback<TableTextStylesResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getAllTableTextStylesValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<TableTextStylesResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getTableTextStyle
     * @param request GetTableTextStyle request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getTableTextStyleCall(GetTableTextStyleRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/views/{viewUid}/tabletextstyles/{rowUid}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()))
            .replaceAll("\\{" + "viewUid" + "\\}", apiClient.escapeString(request.getviewUid().toString()))
            .replaceAll("\\{" + "rowUid" + "\\}", apiClient.escapeString(request.getrowUid().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "field", request.getfield());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getTableTextStyleValidateBeforeCall(GetTableTextStyleRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling getTableTextStyle");
        }
        
        // verify the required parameter 'viewUid' is set
        if (request.getviewUid() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'viewUid' when calling getTableTextStyle");
        }
        
        // verify the required parameter 'rowUid' is set
        if (request.getrowUid() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'rowUid' when calling getTableTextStyle");
        }
        

        com.squareup.okhttp.Call call = getTableTextStyleCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Read specified table text style from specified view.
     * 
     * request GetTableTextStyle request with main agrs
     * @return TableTextStyleResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public TableTextStyleResponse getTableTextStyle(GetTableTextStyleRequest request) throws ApiException {
        try {
            ApiResponse<TableTextStyleResponse> resp = getTableTextStyleWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<TableTextStyleResponse> resp = getTableTextStyleWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Read specified table text style from specified view.
     * 
     * @param request GetTableTextStyle request with main agrs
     * @return ApiResponse&lt;TableTextStyleResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<TableTextStyleResponse> getTableTextStyleWithHttpInfo(GetTableTextStyleRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getTableTextStyleValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<TableTextStyleResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Read specified table text style from specified view. (asynchronously)
     * 
     * @param request GetTableTextStyle request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getTableTextStyleAsync(GetTableTextStyleRequest request, final ApiCallback<TableTextStyleResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getTableTextStyleValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<TableTextStyleResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getViews
     * @param request GetViews request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getViewsCall(GetViewsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/views"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getViewsValidateBeforeCall(GetViewsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling getViews");
        }
        

        com.squareup.okhttp.Call call = getViewsCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Read all project views.
     * 
     * request GetViews request with main agrs
     * @return ViewsResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ViewsResponse getViews(GetViewsRequest request) throws ApiException {
        try {
            ApiResponse<ViewsResponse> resp = getViewsWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<ViewsResponse> resp = getViewsWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Read all project views.
     * 
     * @param request GetViews request with main agrs
     * @return ApiResponse&lt;ViewsResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<ViewsResponse> getViewsWithHttpInfo(GetViewsRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getViewsValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<ViewsResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Read all project views. (asynchronously)
     * 
     * @param request GetViews request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getViewsAsync(GetViewsRequest request, final ApiCallback<ViewsResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getViewsValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ViewsResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for updateTableTextStyle
     * @param request UpdateTableTextStyle request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call updateTableTextStyleCall(UpdateTableTextStyleRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.gettableTextStyle();

        // create path and map variables
        String localVarPath = "/tasks/{name}/views/{viewUid}/tabletextstyles"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()))
            .replaceAll("\\{" + "viewUid" + "\\}", apiClient.escapeString(request.getviewUid().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fileName", request.getfileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call updateTableTextStyleValidateBeforeCall(UpdateTableTextStyleRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling updateTableTextStyle");
        }
        
        // verify the required parameter 'viewUid' is set
        if (request.getviewUid() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'viewUid' when calling updateTableTextStyle");
        }
        
        // verify the required parameter 'tableTextStyle' is set
        if (request.gettableTextStyle() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'tableTextStyle' when calling updateTableTextStyle");
        }
        

        com.squareup.okhttp.Call call = updateTableTextStyleCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Update table text style in specified view.
     * 
     * request UpdateTableTextStyle request with main agrs
     * @return AsposeResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AsposeResponse updateTableTextStyle(UpdateTableTextStyleRequest request) throws ApiException {
        try {
            ApiResponse<AsposeResponse> resp = updateTableTextStyleWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<AsposeResponse> resp = updateTableTextStyleWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Update table text style in specified view.
     * 
     * @param request UpdateTableTextStyle request with main agrs
     * @return ApiResponse&lt;AsposeResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<AsposeResponse> updateTableTextStyleWithHttpInfo(UpdateTableTextStyleRequest request) throws ApiException {
        com.squareup.okhttp.Call call = updateTableTextStyleValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Update table text style in specified view. (asynchronously)
     * 
     * @param request UpdateTableTextStyle request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updateTableTextStyleAsync(UpdateTableTextStyleRequest request, final ApiCallback<AsposeResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = updateTableTextStyleValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getWbsDefinition
     * @param request GetWbsDefinition request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getWbsDefinitionCall(GetWbsDefinitionRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/tasks/{name}/wbsDefinition"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "multipart/form-data"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getWbsDefinitionValidateBeforeCall(GetWbsDefinitionRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling getWbsDefinition");
        }
        

        com.squareup.okhttp.Call call = getWbsDefinitionCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get a project&#39;s WBS Definition.
     * 
     * request GetWbsDefinition request with main agrs
     * @return WBSDefinitionResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public WBSDefinitionResponse getWbsDefinition(GetWbsDefinitionRequest request) throws ApiException {
        try {
            ApiResponse<WBSDefinitionResponse> resp = getWbsDefinitionWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<WBSDefinitionResponse> resp = getWbsDefinitionWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Get a project&#39;s WBS Definition.
     * 
     * @param request GetWbsDefinition request with main agrs
     * @return ApiResponse&lt;WBSDefinitionResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<WBSDefinitionResponse> getWbsDefinitionWithHttpInfo(GetWbsDefinitionRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getWbsDefinitionValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<WBSDefinitionResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get a project&#39;s WBS Definition. (asynchronously)
     * 
     * @param request GetWbsDefinition request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getWbsDefinitionAsync(GetWbsDefinitionRequest request, final ApiCallback<WBSDefinitionResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getWbsDefinitionValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<WBSDefinitionResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for putRenumberWbsCode
     * @param request PutRenumberWbsCode request with main agrs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call putRenumberWbsCodeCall(PutRenumberWbsCodeRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.gettaskUids();

        // create path and map variables
        String localVarPath = "/tasks/{name}/renumberWbsCode"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getname().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getstorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fileName", request.getfileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getfolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "multipart/form-data"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call putRenumberWbsCodeValidateBeforeCall(PutRenumberWbsCodeRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'name' is set
        if (request.getname() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'name' when calling putRenumberWbsCode");
        }
        
        // verify the required parameter 'taskUids' is set
        if (request.gettaskUids() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'taskUids' when calling putRenumberWbsCode");
        }
        

        com.squareup.okhttp.Call call = putRenumberWbsCodeCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Renumber WBS code of passed tasks (if specified) or all project&#39;s tasks.
     * 
     * request PutRenumberWbsCode request with main agrs
     * @return AsposeResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AsposeResponse putRenumberWbsCode(PutRenumberWbsCodeRequest request) throws ApiException {
        try {
            ApiResponse<AsposeResponse> resp = putRenumberWbsCodeWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<AsposeResponse> resp = putRenumberWbsCodeWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Renumber WBS code of passed tasks (if specified) or all project&#39;s tasks.
     * 
     * @param request PutRenumberWbsCode request with main agrs
     * @return ApiResponse&lt;AsposeResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<AsposeResponse> putRenumberWbsCodeWithHttpInfo(PutRenumberWbsCodeRequest request) throws ApiException {
        com.squareup.okhttp.Call call = putRenumberWbsCodeValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Renumber WBS code of passed tasks (if specified) or all project&#39;s tasks. (asynchronously)
     * 
     * @param request PutRenumberWbsCode request with main agrs
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call putRenumberWbsCodeAsync(PutRenumberWbsCodeRequest request, final ApiCallback<AsposeResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = putRenumberWbsCodeValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
private String addParameterToQuery(List<Pair> queryParams, String path, String paramName, Object paramValue) {
        if (path.contains("{" + paramName + "}")) {
            if (paramValue == null || paramValue.equals("")) {
                return path.replace("{" + paramName + "}", "");
            } 
            else {
                return path.replace("{" + paramName + "}", paramValue.toString());
            }
        }

        queryParams.addAll(apiClient.parameterToPair(paramName, paramValue));
        return path;
    }
}
