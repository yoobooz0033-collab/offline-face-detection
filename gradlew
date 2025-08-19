#!/usr/bin/env sh

##############################################################################
##
##  Gradle start up script for UN*X
##
##############################################################################

APP_HOME=$(cd "${0%/*}" && pwd -P)
DEFAULT_JVM_OPTS=""

JAVA_EXE="java"
if [ -n "$JAVA_HOME" ] ; then
    JAVA_EXE="$JAVA_HOME/bin/java"
fi

exec "$JAVA_EXE" $DEFAULT_JVM_OPTS -cp "$APP_HOME/gradle/wrapper/gradle-wrapper.jar" org.gradle.wrapper.GradleWrapperMain "$@"
