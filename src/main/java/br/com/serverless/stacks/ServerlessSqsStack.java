package br.com.serverless.stacks;

import software.constructs.Construct;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
 import software.amazon.awscdk.Duration;
 import software.amazon.awscdk.services.sqs.Queue;

public class ServerlessSqsStack extends Stack {

    public ServerlessSqsStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public ServerlessSqsStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);



         final Queue queue = Queue.Builder.create(this, "ServerlessSqsQueue")
                 .visibilityTimeout(Duration.seconds(300))
                 .build();
    }
}
