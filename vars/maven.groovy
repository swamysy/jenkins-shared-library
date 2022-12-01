def call() {
    node {
        env.APPTYPE="maven"
        common.lintChecks()
       env.ARGS="-Dsonar.java.binaries=target/"
        common.sonarChecks()   
        common.testCases()
    }
}


// function call will be called by default, when you call the fileName
// def call() {
//     pipeline{
//         agent any 
//         environment {
//             SONAR    = credentials('SONAR')
//             SONARURL = "172.31.0.59"
//         } 
//         stages {
//             stage('Lint Checks') {
//                 steps {
//                     script {
//                         common.lintChecks()                  // Use script { when you're using groovy based conventions }
//                     }
//                 }
//             }

//             stage('Sonar Checks') {
//                 steps {
//                     script {
//                         sh "mvn clean compile"
//                         env.ARGS="-Dsonar.java.binaries=target/"
//                         common.sonarChecks()                  // Use script { when you're using groovy based conventions }
//                     }
//                 }
//             }     
//             stage('Test Cases') {
//                 parallel {
//                     stage('Unit Testing') {                 
//                         steps {
//                             sh "echo Unit Testing Completed"   
//                                 }
//                             }
//                     stage('Integration Testing') {                 
//                         steps {
//                             sh "echo Integration Testing Completed"   
//                                 }
//                             }
//                     stage('Function Testing') {                 
//                         steps {
//                             sh "echo Function Testing Completed"   
//                                 }
//                             }
//                         }         
//                     }
//             }   // end of stages 
//         }  // end of pipelines
//     } // end of call



