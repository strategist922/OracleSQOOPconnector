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

package com.quest.oraoop.systemtest.util;

/**
 * Generates test data for Oracle INTERVAL YEAR TO MONTH columns.
 * @author phall
 */
public class IntervalYearMonthGenerator extends TestDataGenerator<String>
{
  private final int precision;
  private final int minYear;
  private final int maxYear;

  /**
   * Create a generator that will generate intervals with the specified precision for years
   * @param precision Number of decimal digits in the years part of each interval
   */
  public IntervalYearMonthGenerator(int precision)
  {
    super();
    this.precision = precision;
    this.minYear = -(int)Math.pow(10, precision) + 1;
    this.maxYear = (int)Math.pow(10, precision) - 1;
  }

  @Override
  public String next()
  {
    int years = minYear + rng.nextInt(maxYear - minYear + 1);
    int months = rng.nextInt(12);
    return String.format("%+0" + precision + "d-%02d", years, months);
  }
}
