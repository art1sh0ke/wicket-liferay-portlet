## Achievement Portlet

This is an example portlet developed for series of my blog posts (in Russian):

1. [http://www.shafranov.net/blog/2012/06/08/liferay-wicket-1-liferay/](http://www.shafranov.net/blog/2012/06/08/liferay-wicket-1-liferay/)
2. [http://www.shafranov.net/blog/2012/06/08/liferay-wicket-2-wicket-webxml/](http://www.shafranov.net/blog/2012/06/08/liferay-wicket-2-wicket-webxml/)
3. [http://www.shafranov.net/blog/2012/08/18/sozdaniie-portlieta-dlia-liferay-s-pomoshchiu-wicket-chast-3-razrabotka-funktsionalnosti-portlieta/](http://www.shafranov.net/blog/2012/08/18/sozdaniie-portlieta-dlia-liferay-s-pomoshchiu-wicket-chast-3-razrabotka-funktsionalnosti-portlieta/)

Example demonstrates how to use Apache Wicket framework to develop AJAX-enabled portlet for Liferay Portal. 

In the VIEW mode portlet shows a simple string that contains information about an achievement. That information can be changed in the EDIT mode of the portlet with the help of AJAX controls.

### Used versions

Example was developed using Apache Wicket 1.4.x and for Liferay Portal 6.0.6.

### How to run 

To run this example on Liferay you should add file build.custom.properties to achievement-portlet folder. That file will contain one single line:

    liferay.sdk.home=${LIFERAY_SDK_HOME}

where LIFERAY_SDK_HOME is the location of the Liferay Plugins SDK.

### How to run on Liferay 6.1.x

You may try to run this example on Liferay 6.1.x as well. Just add the following line to liferay-plugin-package.properties:

    liferay-web-xml-enabled=false
    