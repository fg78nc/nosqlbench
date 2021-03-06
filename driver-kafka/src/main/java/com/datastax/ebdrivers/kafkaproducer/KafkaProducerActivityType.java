package com.datastax.ebdrivers.kafkaproducer;

import io.nosqlbench.activitytype.stdout.StdoutAction;
import io.nosqlbench.activitytype.stdout.StdoutActivity;
import io.nosqlbench.engine.api.activityapi.core.Action;
import io.nosqlbench.engine.api.activityapi.core.ActionDispenser;
import io.nosqlbench.engine.api.activityapi.core.ActivityType;
import io.nosqlbench.engine.api.activityimpl.ActivityDef;
import io.nosqlbench.nb.annotations.Service;

@Service(ActivityType.class)
public class KafkaProducerActivityType implements ActivityType<KafkaProducerActivity> {
    @Override
    public String getName() {
        return "kafkaproducer";
    }

    @Override
    public KafkaProducerActivity getActivity(ActivityDef activityDef) {
        return new KafkaProducerActivity(activityDef);
    }

    private static class Dispenser implements ActionDispenser {
        private StdoutActivity activity;

        private Dispenser(StdoutActivity activity) {
            this.activity = activity;
        }

        @Override
        public Action getAction(int slot) {
            return new StdoutAction(slot,this.activity);
        }
    }

    @Override
    public ActionDispenser getActionDispenser(KafkaProducerActivity activity) {
        return new Dispenser(activity);
    }
}
