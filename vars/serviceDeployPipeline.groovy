import com.mflyyou.PipelineParam

def call(PipelineParam config) {
    def script = this
    agent { docker { image 'maven:3.9.4-eclipse-temurin-17-alpine' } }
    stages {
        stage('build') {
            steps {
                script.sh 'mvn --version'
                script.echo "echo ${config.branchName}"
            }
        }
    }
}
