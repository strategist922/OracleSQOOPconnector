/**
 *   Copyright 2012 Quest Software, Inc.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.quest.oraoop;

public class OraOopLogMessage {
    public OraOopConstants.Logging.Level level;
    public String message;

    public OraOopLogMessage(OraOopConstants.Logging.Level level, String message) {

        this.level = level;
        this.message = message;
    }

    public void log(OraOopLog log) {

        switch (this.level) {
            case TRACE:
                log.trace(this.message);
                break;
            case DEBUG:
                log.debug(this.message);
                break;
            case INFO:
                log.info(this.message);
                break;
            case WARN:
                log.warn(this.message);
                break;
            case ERROR:
                log.error(this.message);
                break;
            case FATAL:
                log.fatal(this.message);
                break;
            default:
                throw new RuntimeException(String.format("%s needs to be updated to cater for the message level \"%s\"."
                                                        ,OraOopUtilities.getCurrentMethodName()
                                                        ,this.level.toString()));
        }
    }
}