package br.com.serverless;

import br.com.serverless.stacks.ServerlessSqsStack;
import software.amazon.awscdk.App;
import software.amazon.awscdk.Environment;
import software.amazon.awscdk.StackProps;

public class ServerlessSqsApp {
    public static void main(final String[] args) {
        App app = new App();

        new ServerlessSqsStack(app, "ServerlessSqsStack", StackProps.builder()
                .env(Environment.builder()
                        .account(System.getenv("CDK_DEFAULT_ACCOUNT"))
                        .region(System.getenv("CDK_DEFAULT_REGION"))
                        .build())

                .env(Environment.builder()
                        .account("123456789012")
                        .region("us-east-1")
                        .build())

                .build());

        app.synth();
    }
}

