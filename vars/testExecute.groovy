#!/usr/bin/env groovy

def call(){
    def runCmd = "sleep 10".execute()
    // runCmd.waitFor()
    println "command exit code " + runCmd.exitValue()
}