#!/usr/bin/env groovy

def call(){
    def runCmd = "sleepy 10".execute()
    runCmd.waitFor()
    println "command exit code " + runCmd.exitValue()
}