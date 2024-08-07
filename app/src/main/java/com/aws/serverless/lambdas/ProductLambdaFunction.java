package com.aws.serverless.lambdas;

import org.jetbrains.annotations.Nullable;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.constructs.Construct;

public class ProductLambdaFunction extends Stack {

    public ProductLambdaFunction(@Nullable Construct scope, @Nullable String id) {
        super(scope, id, null);
    }

    public ProductLambdaFunction(@Nullable Construct scope, @Nullable String id, @Nullable StackProps props) {
        super(scope, id, props);

    private void createLambdaFunction() {
        // Create a Lambda function
        Function productLambda = Function.Builder.create(this, "productLambda")
                .code(Code.fromAsset("path/to/lambda/code"))
                .handler("index.handler")
                .runtime(Runtime.NODEJS_14_X)
                .timeout(Duration.seconds(30))
                .memorySize(512)
                .build();






    }
}
