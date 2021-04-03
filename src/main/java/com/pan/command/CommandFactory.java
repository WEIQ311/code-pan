/*
 * #%L
 * %%
 * Copyright (C) 2015 Trustsystems Desenvolvimento de Sistemas, LTDA.
 * %%
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * 3. Neither the name of the Trustsystems Desenvolvimento de Sistemas, LTDA. nor the names of its contributors
 *    may be used to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 * #L%
 */
package com.pan.command;

import com.pan.support.concurrency.GenericCache;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;

@Slf4j
public class CommandFactory implements ElfinderCommandFactory {


    private final GenericCache<String, ElfinderCommand> cache = new GenericCache<>();
    private String classNamePattern;

    @Override
    public ElfinderCommand get(final String commandName) {
        if (commandName == null || commandName.trim().isEmpty()) {
            log.error(String.format("Command {} cannot be null or empty", commandName));
            throw new RuntimeException(String.format("Command %s cannot be null or empty", commandName));
        }

        ElfinderCommand command = null;

        try {
            command = cache.getValue(commandName, () -> {
                log.debug(String.format("trying recovery command!: {}", commandName));
                String className = String.format(getClassNamePattern(), commandName.substring(0, 1).toUpperCase() + commandName.substring(1));
                log.info("className:{}", className);
                return (ElfinderCommand) Class.forName(className).newInstance();
            });
            log.debug(String.format("command found!: {}", commandName));
        } catch (InterruptedException | ExecutionException e) {
            log.error("Unable to get/create command instance.", e);
        }
        return command;
    }

    private String getClassNamePattern() {
        return classNamePattern;
    }

    public void setClassNamePattern(String classNamePattern) {
        this.classNamePattern = classNamePattern;
    }
}
