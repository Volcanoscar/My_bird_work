/*
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yunos.alicontacts.vcard;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;

/**
 * A base processor class. One instance processes vCard one import/export request (imports a given
 * vCard or exports a vCard). Expected to be used with {@link ExecutorService}.
 *
 * This instance starts itself with {@link #run()} method, and can be cancelled with
 * {@link #cancel(boolean)}. Users can check the processor's status using {@link #isCancelled()}
 * and {@link #isDone()} asynchronously.
 *
 * {@link #get()} and {@link #get(long, TimeUnit)}, which are form {@link Future}, aren't
 * supported and {@link UnsupportedOperationException} will be just thrown when they are called.
 */
public abstract class ProcessorBase {

    /**
     * @return the type of the processor. Must be {@link VCardService#TYPE_IMPORT} or
     * {@link VCardService#TYPE_EXPORT}.
     */
    public abstract int getType();

    /**
     * @return the JobId for this processor
     */
    public abstract int getJobID();

    public abstract void run();

    /**
     * Cancels this operation.
     *
     * @param mayInterruptIfRunning ignored. When this method is called, the instance
     * stops processing and finish itself even if the thread is running.
     *
     * @see Future#cancel(boolean)
     */

    public abstract boolean cancel(boolean mayInterruptIfRunning);

    public abstract boolean isCancelled();

    public abstract boolean isDone();
}
