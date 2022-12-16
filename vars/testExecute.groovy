#!/usr/bin/env groovy

def call(){
    List<String> cmds = [
        "echo hello && false",
        "echo world && false",
        "echo bye",
        "ls -l && false"
    ]
   for (int i = 0; i < cmds.size(); i++) {
        def runCmd = cmds[i].execute()
        runCmd.waitFor()
        def exitCode = runCmd.exitValue()
        println "command exit code " + exitCode
        if (exitCode == 0) {
            println "exit code is 0, exiting loop"
            break
        }
   }
}