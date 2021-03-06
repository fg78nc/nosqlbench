package io.nosqlbench.virtdata.library.basics.shared.conversions.from_long;

import io.nosqlbench.virtdata.api.annotations.Categories;
import io.nosqlbench.virtdata.api.annotations.Category;
import io.nosqlbench.virtdata.api.annotations.Example;
import io.nosqlbench.virtdata.api.annotations.ThreadSafeMapper;

import java.util.function.LongToIntFunction;

/**
 * Convert the input value to an int with long modulus remainder.
 * If the scale is chosen, then the value is wrapped at this value.
 * Otherwise, {@link Integer#MAX_VALUE} is used.
 */
@ThreadSafeMapper
@Categories({Category.conversion})
public class ToInt implements LongToIntFunction {

    private final int scale;

    @Example({"ToInt(1000)","converts a long input value to an int between 0 and 999, inclusive"})
    public ToInt(int scale) {
        this.scale = scale;
    }

    @Example({"ToInt()","converts a long input value to an int between 0 and 2147483647, inclusive "})
    public ToInt() {
        this.scale = Integer.MAX_VALUE;
    }

    @Override
    public int applyAsInt(long input) {
        return (int) (input % scale);
    }
}
