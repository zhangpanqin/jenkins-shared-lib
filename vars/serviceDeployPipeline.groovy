import com.mflyyou.PipelineParam

def call(PipelineParam config) {
    def script = this
    pipeline {
        agent { docker { image 'maven:3.9.4-eclipse-temurin-17-alpine' } }
        stages {
            stage('build') {
                steps {
                    sh 'mvn --version'
                    echo "echo ${config.branchName}"
                }
            }
        }
    }
}
