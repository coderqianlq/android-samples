<div align="center">
     <img src="https://image.ibb.co/b2x0v0/a.jpg" />
</div>

## 序：首页搭建教程

修改 app 目录下的 build.gradle 文件。
第一步，添加 repositories，如下：
```js
repositories {
    maven {
        url "https://jitpack.io"
    }
}
```
第二步，添加依赖，在 dependencies 下加入 CircularReveal 依赖：
```js
dependencies {
    compile 'com.github.ozodrukh:CircularReveal:1.0.4'
    compile 'com.github.yalantis:Side-Menu.Android:1.0.1' // 侧边栏，根据需要添加
}
```
修改后的 build.gradle 文件如下：
```js
apply plugin: 'com.android.application'

android {
    compileSdkVersion 26
    defaultConfig {
        applicationId 'com.coderqian'
        minSdkVersion 15
        targetSdkVersion 26
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
    productFlavors {
    }
}

repositories {
    maven {
        url 'https://maven.google.com'
    }
    maven {
        url "https://jitpack.io"
    }
}

dependencies {
    implementation fileTree(include: ['*.jar'], dir: 'libs')
    implementation 'com.android.support.constraint:constraint-layout:1.1.3'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'com.android.support.test:runner:1.0.2'
    androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.2'
    compile 'com.github.ozodrukh:CircularReveal:1.0.4'
    compile 'com.github.yalantis:Side-Menu.Android:1.0.1'
    implementation 'com.android.support:appcompat-v7:26.1.0'
    compile project(path: ':library')
}
```
> 项目所引入依赖的 GitHub 地址：
> [CircularReveal](https://github.com/ozodrukh/CircularReveal)
> [Side-Menu](https://github.com/Yalantis/Side-Menu.Android) 

首页效果
<div align="center">
    <img src="https://preview.ibb.co/ijfvdL/Screenshot-1540991947.png" width="20%" >
</div>
<br/>

## 1、搭建 Android 应用开发环境

下载Android Studio，搭建Android应用开发环境，熟悉基本Android开发、调试工具。用AndroidStudio创建第一个Android应用，对该应用进行签名，并能把该应用部署至Android模拟器、GenyMotion模拟器和真机上。

Android Studio 安装参考菜鸟教程 [Android Studio 安装](http://www.runoob.com/android/android-studio-install.html)。

## 2、练习 Android 控件的使用

编写一个Android应用，练习各种Android控件的使用，该应用可以是单机应用，无需添加网络访问功能。可模仿常用的工具类应用或热门应用的界面来完成自己应用界面的布局。要求下列每一组组件都要用到，每一组组件至少使用其中一种组件。<br/>
1）布局管理器<br/>
2）TextView及其子类<br/>
3）ImageView及其子类<br/>
4）AdapterView及其子类<br/>
5）ProgressBar及其子类<br/>
6）ViewAnimator及其子类<br/>
7）各种杂项组件<br/>
8）对话框

## 3、熟悉 Android 事件处理机制

熟悉Android事件处理机制、Activity及其子类，写一个实验应用，要求：<br/>
1）包含  多  个Activity，  并  至  少  使  用TabActivity、PreferenceActivity、ListActivity、LauncherActivity、ExpandableListActivity中的两种。<br/>
2）该应用要包含菜单、对话框、Toast消息提醒。<br/>
3）向该应用中添加事件处理代码。

## 4、练习 Fragment、Intent 和各种资源的使用

练习 Fragment、Intent 和各种资源的使用。

## 5、实现几种绘图和动画效果

练习各种资源的使用，并实现几种绘图和动画效果。

🍁枫叶进度条
<div align="center">
  <img src="https://preview.ibb.co/dNbzoL/Screenshot-1540993179.png" width="20%" />
</div>
<br/>

## 6、建立SQLite数据库和表，封装访问方法

建立一个SQLite数据库，并建立至少一个表，向表内添加一些数据。建立一个ContentProvider对该数据库的访问进行封装，并提供访问接口。开发一个测试应用，能够通过ContentResolver对前一应用的数据库进行增删改查。

## 7、进程内服务和简易网络聊天室应用

1）编程建立一个进程内服务，服务提供int compare(int, int)函数，输入两个整数，输出较大的整数，添加一个Activity，与该Service绑定，并能够调用该Service中的compare函数，显示输出结果。<br/>
2) 基于Socket编程实现一个简易网络聊天室应用（包括服务器端和Android客户端）。


