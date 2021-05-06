stage 'Compile'
node() {
    checkout scm
    def mvnHome = '/usr/'
    sh "/usr/bin/mvn clean install -DskipTests"
    stash 'working-copy'
}

stage 'Test'
parallel one: {
    node() {
        unstash 'working-copy'
        //def mvnHome = tool 'maven-3'
        sh "/usr/bin/mvn test -Diterations=10"
    }
}, two: {
    node() {
        unstash 'working-copy'
    def mvnHome = '/usr/'
        sh "${mvnHome}/bin/mvn test -Diterations=5"
    }
}, failFast: true

stage name: 'Deploy', concurrency: 1
def path = input message: 'Where should I deploy this build?', parameters: [[$class: 'StringParameterDefinition', name: 'FILE_PATH']]
node() {
    unstash 'working-copy'
    sh "cp target/example-1.0-SNAPSHOT.jar ${path}"
}
