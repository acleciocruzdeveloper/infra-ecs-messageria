package com.aws.serverless;

import org.jetbrains.annotations.Nullable;
import software.amazon.awscdk.Duration;
import software.amazon.awscdk.RemovalPolicy;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.lambda.Code;
import software.amazon.awscdk.services.lambda.Function;
import software.amazon.awscdk.services.lambda.Runtime;
import software.amazon.awscdk.services.sqs.Queue;
import software.constructs.Construct;

public class ProductStack extends Stack {

    public ProductStack(@Nullable Construct scope, @Nullable String id) {
        super(scope, id, null);
    }

    public ProductStack(@Nullable Construct scope, @Nullable String id, @Nullable StackProps props) {
        super(scope, id, props);

        Queue productSqsStack = Queue.Builder.create(this, "productSqsStack")
                .removalPolicy(RemovalPolicy.DESTROY)
                .build();

        Function productLambdaStack = Function.Builder.create(this, "productLambdaStack")
                .code(Code.fromAsset("com.myorg.ProductLambdaFunction"))
                .handler("index.handler")
                .runtime(Runtime.JAVA_17)
                .timeout(Duration.seconds(12))
                .memorySize(512)
                .build();

        productSqsStack.grantConsumeMessages(productLambdaStack);
    }
}
