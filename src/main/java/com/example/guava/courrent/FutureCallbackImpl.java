package com.example.guava.courrent;

import com.google.common.util.concurrent.FutureCallback;
import org.jspecify.annotations.Nullable;

/**
 * @author: lingjun.jlj
 * @date: 2022/2/27 12:46
 * @description:
 */
public class FutureCallbackImpl implements FutureCallback<String> {

    @Override
    public void onSuccess(@Nullable String s) {

    }

    @Override
    public void onFailure(Throwable throwable) {

    }
}
