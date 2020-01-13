## TabNine-Eclipse

TabNine-Eclipse is a plug-in working in Eclipse Platform with the core executable file  from [TabNine](https://github.com/zxqfl/TabNine) by [zxqfl](https://github.com/zxqfl).

This repository is the source code of TabNine-Eclipse, but with no core file which provided from [TabNine](https://github.com/zxqfl/TabNine).

This plug-in is developed and tested in JDK 1.8 and Eclipse platform 2019-09 Release.

This plug-in support follows editor now:

- JDT Based Standard Java Editor
- JSDT Based Standard JavaScript Editor
- Generic Text Editor

## Screenshot

![Image-01](https://github.com/GitPopcorn/tabnine-eclipse/raw/master/screenshot/2020-01-13-tabnine-eclipse-screenshot-01.jpg)

![Image-02](https://github.com/GitPopcorn/tabnine-eclipse/raw/master/screenshot/2020-01-13-tabnine-eclipse-screenshot-02.jpg)

## Changelogs

### 1.0.0-TEST (January 13, 2019)

- Init commit, adding TabNine completion function support to follows editors:
  - JDT Based Standard Java Editor
  - JSDT Based Standard JavaScript Editor
  - Generic Text Editor

## Installation

#### 1. Clone repository/Download source code

You can clone this repo by command line or just download ZIP pack, in short you should put the source code in your Eclipse workspace firstly.

#### 2. Import the plug-in project into workspace of Eclipse

Start Eclipse and open workspace, import the plug-in project as "Projects from Folder or Archive"(File Menu -> Import -> General -> Projects from Folder or Archive -> Select directory and impoort this plug-in project).

#### 3. Download the TabNine core file manully

If you will use this plug-in in a online enviroment, this step can be just skipped.

If you will use this plug-in in a offline enviroment, open the [com.tabnine.eclipse.module.impl.TabNineCoreRunnerBasicImpl.java](https://github.com/GitPopcorn/tabnine-eclipse/blob/master/src/main/java/com/tabnine/eclipse/module/impl/TabNineCoreRunnerBasicImpl.java), then run it as a Java Application using Eclipse(You can also run it by the command line tools of Java like javac/java).

When this application successfully ended, a TabNine Core file with latest version saving in the */target/tabnine-core/${TABNINE_VERSION}/${OS_PLATFORM}/* position, copy that *tabnine-core* folder to */src/main/resources/tabnine-core* position. so it will be export to the plug-in package when we compile.

#### 4. Export and pack the plug-in

Note: *This step must be processed with Eclipse or other OSGi platform util, cause we need to pack this plug-in with the rule provided by Eclipse*

- File Menu -> Export -> Plug-in Development -> Deployable plug-ins and fragments. 
- Select this project, choose Directory as Destination, you can using Desktop or somewhere as this Directory, but recommended with the root folder where your Eclipse located in(e.g. *C:\Program Files\eclipse\jee-2019-09R\eclipse*).
- Finish the export operation, you will get a JAR file like */plugin/com.tabine.eclipse_${PLUGIN_VERSION}.jar*.

#### 5. Move the package to the .plug-in folder of Eclipse

If you choose Eclipse root folder as the exporting destination, you can just skip this type.

Put the JAR file we got from exportation to the */plugin* folder under Eclipse root folder(e.g. *C:\Program Files\eclipse\jee-2019-09R\eclipse\plugins*).

you can also unpack the JAR file and put unpacking result to this folder, it still works(But don't put the JAR file and unpacking document together).

#### 6. Start or restart targeted Eclipse Instance

Start or restart the Eclipse where you put plug-in in, and the use it.

## Knowing Issues

- Test with lower version JDK or Eclipse Platform has not be done.
- Test with MacOS or Linux operation system has not be done.
- Cannot support multiline completion yet, and I also do not know if the TabNine core support it.
- Cannot reuse the progress of TabNine core program, each Eclipse instance will holding its own TabNine core program.
- When working in Generic Text Editor, the real path of eidting file cannot be accessed by plug-in.
- No downloading progress will be shown when the plug-in try to download the TabNine core file.

## Configurations

#### 1. Close the downloading function

When this plug-in is used in a offline enviroment, we can turn off the downloader by set constant [com.tabnine.eclipse.constant.TabNineConstants#IS_TABNINE_CORE_DOWNLOADER_AVAILABLE](https://github.com/GitPopcorn/tabnine-eclipse/blob/master/src/main/java/com/tabnine/eclipse/constant/TabNineConstants.java) to false.

#### 2. Change the context extraction range 

When we send completion request to TabNine core program, we can take the context text from current line or the whole document. That would affect the accuracy and cost of TabNine core program.

We can change this setting by editing follow constant: 

- [com.tabnine.eclipse.TabNineContentAssistProcessor#OPTION_COMPUT_RANGE](https://github.com/GitPopcorn/tabnine-eclipse/blob/master/src/main/java/com/tabnine/eclipse/TabNineContentAssistProcessor.java)
- [com.tabnine.eclipse.TabNineJavaCompletionProposalComputer#OPTION_COMPUT_RANGE](https://github.com/GitPopcorn/tabnine-eclipse/blob/master/src/main/java/com/tabnine/eclipse/TabNineJavaCompletionProposalComputer.java)
- [com.tabnine.eclipse.TabNineJavaScriptCompletionProposalComputer#OPTION_COMPUT_RANGE](https://github.com/GitPopcorn/tabnine-eclipse/blob/master/src/main/java/com/tabnine/eclipse/TabNineJavaScriptCompletionProposalComputer.java)