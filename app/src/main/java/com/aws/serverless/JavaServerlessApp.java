package com.aws.serverless;

import software.amazon.awscdk.App;
import software.amazon.awscdk.Environment;
import software.amazon.awscdk.StackProps;

public class JavaServerlessApp {
    public static void main(final String[] args) {
        App app = new App();

        new ProductStack(app, "productStack", StackProps.builder()
                .env(Environment.builder()
                        .account("905418418666")
                        .region("us-east-1")
                        .build())
                .build());

        app.synth();
    }
}

