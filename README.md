# Manipulate MS Project Files in Java via Cloud REST API

Aspose.Tasks for Cloud offers the ability to manipulate and convert Microsoft Project MPT, MPP, MPX & Oracle Primavera XER, XML, and PrimaveraP6XML files in Java. [Aspose.Tasks Cloud SDK for Java](https://products.aspose.cloud/tasks/java) wraps the REST API to make it easier for the developers to integrate MS Project Task Management features in their own cloud-based Java applications on Linux, MacOS, Windows or Android.

Feel free to explore the [Developer's Guide](https://docs.aspose.cloud/display/taskscloud/Developer+Guide) & [API Reference](https://apireference.aspose.cloud/tasks/) to know all about Aspose.Tasks Cloud API.

## MS Project Processing Features
- Add project assignments or delete project assignments along with their references.
- Get the project's outline codes by index & get links to all project tasks.
- Import projects from Primavera DB formats or from databases with the specified connection string.
- Get UIDs of all projects contained in the file & fetch the required assignment with the project based on UID.
- Manage project tasks, resource data, calendars & Work Breakdown Structure (WBS).
- Perform risk analysis using Monte Carlo simulation and create a report.
- Create and set project document properties & fetch all or specific existing properties.
- Get a project's extended attributes, time-scaled data, or recurring info of a specific task.
- Reschedule project tasks, dates, and other settings.
- Calculate slacks & recalculate project completion or incompletion work.
- Fetch a project document in the desired format.
- Delete project task with its related references & rebuild the task tree.
- [Convert project documents](https://docs.aspose.cloud/tasks/convert-project-document-to-the-specified-format/) to other formats.
- Manipulate task data.
- [Manage project's resources](https://docs.aspose.cloud/tasks/working-with-resources/).
- Handle task links & task assignments.
- Work with project's extended attributes.
- [Read Microsoft Project’s document properties](https://docs.aspose.cloud/tasks/working-with-calendars/) such as start and finish date, tasks scheduling types and so on.
- [Read Microsoft Project’s Calendars](https://docs.aspose.cloud/tasks/working-with-calendars/) and Calendar Exceptions information.

## Read & Write Project Data
**Microsoft Project** MPP, XML, MPT **Primavera** MPX

## Save Project Data As
XER, XLSX, HTML, XML, TXT, TIF, SVG, PNG, JPEG


## Enhancements in Version 25.8
- Added new ability to level tasks for the resources.
- Provided the ability to clear leveling delay that was previously added to the tasks during resource leveling.

## Enhancements in Version 25.4
- Enhanced Task model.
- Enhanced TaskLink model.
- Enhanced ProjectRecalculationResult model.

## Enhancements in Version 24.10
- Enhanced reading data from Primavera-specific task's properties.

## Enhancements in Version 24.4
- Added new ability to get views information.
- Possibility to modify table text styles for Gantt Chart views.

## Enhancements in Version 22.12
- Added new ability to read Primavera-specific task's properties.
- Provided the ability to read more document properties.

## Enhancements in Version 20.11
- Support for the batch creation of tasks (i.e. the ability to create multiple tasks in a single *API* call).

## Enhancements in Version 20.8
- Ability to specify the non-default path for Project Server's *PWA* URL.
- Ability to modify *timephasedData* collection in assignments.

## Enhancements in Version 20.6
- Possibility to render comments when saving as image, HTML or PDF.
- Option to use username and password to connect Project Online (Server) instead of auth token, incase you don't have it.
- Ability to add assignments to your project file along with specifying its cost.
- Quickly adding new tasks to project, when calculation mode is set to automatic.
- Ability to add project in Microsoft Project Server.
- Added support of reading shared resource assignments.


## How to use the SDK?
The complete source code is available in this repository folder. You can either directly use it in your project via source code or get [Maven](https://repository.aspose.cloud/webapp/#/artifacts/browse/tree/General/repo/com/aspose/aspose-tasks-cloud) (recommended). For more details, please visit our [documentation website](https://docs.aspose.cloud/display/taskscloud/Available+SDKs).

### Prerequisites

To use Aspose Tasks Cloud SDK for Java you need to register an account with [Aspose Cloud](https://www.aspose.cloud/) and lookup/create App Key and SID at [Cloud Dashboard](https://dashboard.aspose.cloud/#/apps). There is free quota available. For more details, see [Aspose Cloud Pricing](https://purchase.aspose.cloud/pricing).

## Installation & Usage
Add this dependency to your project's POM:

```xml
<repositories>
    <repository>
        <id>aspose-cloud</id>
        <name>artifact.aspose-cloud-releases</name>
        <url>http://artifact.aspose.cloud/repo</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.aspose</groupId>
        <artifactId>aspose-tasks-cloud</artifactId>
        <version>25.10.0</version>
    </dependency>
</dependencies>
```

## Convert MS Project MPP to PDF in Java

```java
        // Start README example

        // if baseUrl is null, TasksApi uses default https://api.aspose.cloud 
        TasksApi tasksApi = new TasksApi(clientId, clientSecret, baseUrl);

        String localPath = PathUtil.get(localFolder, fileName);
        String remotePath = PathUtil.get(remoteFolder, remoteName);

        UploadFileRequest uploadRequest = new UploadFileRequest(Files.readAllBytes(Paths.get(localPath)), remotePath, null);
        tasksApi.uploadFile(uploadRequest);
		
        GetReportPdfRequest request = new GetReportPdfRequest(remoteFileName, ReportType.MILESTONES.getValue(), null, null);
        File result = tasksApi.getReportPdf(request);
		

        // End README example
```

[Test](src/test/java/com/aspose/tasks/cloud) contain various examples of using the SDK.

## Dependencies
- Java 1.7+
- referenced packages (see [here](pom.xml) for more details)

## Licensing

All Aspose.Tasks Cloud SDKs, helper scripts and templates are licensed under [MIT License](https://github.com/aspose-tasks-cloud/aspose-tasks-cloud-java/blob/master/LICENSE). 

## Contact Us
Your feedback is very important to us. Please feel free to contact us using our [Support Forums](https://forum.aspose.cloud/c/tasks).

## Resources

[Website](https://www.aspose.cloud/)  
[Product Home](https://products.aspose.cloud/tasks/family)  
[API Reference](https://apireference.aspose.cloud/tasks/)  
[Documentation](https://docs.aspose.cloud/display/taskscloud/Home)  
[Blog](https://blog.aspose.cloud/category/tasks/)  

## Aspose.Tasks Cloud SDKs in Popular Languages

| .NET | PHP | Python| Node.js | Go |
|---|---|---|---|---|
| [GitHub](https://github.com/aspose-tasks-cloud/aspose-tasks-cloud-dotnet) |[GitHub](https://github.com/aspose-tasks-cloud/aspose-tasks-cloud-php) | [GitHub](https://github.com/aspose-tasks-cloud/aspose-tasks-cloud-python) | [GitHub](https://github.com/aspose-tasks-cloud/aspose-tasks-cloud-node) |[GitHub](https://github.com/aspose-tasks-cloud/aspose-tasks-cloud-go)|
| [NuGet](https://www.nuget.org/packages/Aspose.tasks-Cloud/)| [Composer](https://packagist.org/packages/aspose/tasks-cloud-php) | [PIP](https://pypi.org/project/aspose-tasks-cloud/) | [NPM](https://www.npmjs.com/package/@asposecloud/aspose-tasks-cloud) | [Go.Dev](https://pkg.go.dev/github.com/aspose-tasks-cloud/aspose-tasks-cloud-go/) |

[Product Page](https://products.aspose.cloud/tasks/python) | [Documentation](https://docs.aspose.cloud/display/taskscloud/Home) | [API Reference](https://apireference.aspose.cloud/tasks/) | [Code Samples](https://github.com/aspose-tasks-cloud/aspose-tasks-cloud-python) | [Blog](https://blog.aspose.cloud/category/tasks/) | [Free Support](https://forum.aspose.cloud/c/tasks) | [Free Trial](https://dashboard.aspose.cloud/#/apps)
