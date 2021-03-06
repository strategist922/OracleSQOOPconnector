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

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Generates BigDecimal test data.
 * 
 * @author phall
 */
public class BigDecimalGenerator extends TestDataGenerator<BigDecimal>
{
  private final int precision;
  private final int scale;

  /**
   * Create a BigDecimalGenerator suitable for populating an Oracle NUMBER(precision,scale) field.
   * 
   * @param precision Maximum number of decimal digits in generated BigDecimals
   * @param scale Number of decimal digits to the right of the decimal point in generated BigDecimals
   */
  public BigDecimalGenerator(int precision, int scale)
  {
    super();
    this.precision = precision;
    this.scale = scale;
  }

  @Override
  public BigDecimal next()
  {
    BigInteger unscaled = BigInteger.valueOf(rng.nextInt((int)Math.pow(10, precision)));
    BigDecimal value = new BigDecimal(unscaled, scale);
    if (rng.nextBoolean())
    {
      value = value.negate();
    }
    return value;
  }
}
