/*
 * Copyright © 2022 Mark Raynsford <code@io7m.com> https://www.io7m.com
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY
 * SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR
 * IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */


package com.io7m.taskrecorder.core;

import java.util.Optional;

/**
 * A recorder for the resolution aspects of a step.
 */

public interface TRTaskStepResolutionRecorderType
{
  /**
   * Set the step as having succeeded.
   *
   * @param message The success message
   */

  default void setStepSucceeded(
    final String message)
  {
    this.setStepResolution(new TRStepSucceeded(message));
  }

  /**
   * Set the step as having succeeded.
   */

  default void setStepSucceeded()
  {
    this.setStepSucceeded("");
  }

  /**
   * Set the step as having failed.
   *
   * @param message   The failure message
   * @param exception The exception
   */

  default void setStepFailed(
    final String message,
    final Optional<Throwable> exception)
  {
    this.setStepResolution(new TRStepFailed(message, exception));
  }

  /**
   * Set the step as having failed.
   *
   * @param message   The failure message
   * @param exception The exception
   */

  default void setStepFailed(
    final String message,
    final Throwable exception)
  {
    this.setStepFailed(message, Optional.of(exception));
  }

  /**
   * Set the step as having failed.
   *
   * @param message The failure message
   */

  default void setStepFailed(
    final String message)
  {
    this.setStepFailed(message, Optional.empty());
  }

  /**
   * Set the resolution of the step. By default, steps are considered to have
   * succeeded with an empty resolution message.
   *
   * @param resolution The resolution
   */

  void setStepResolution(
    TRStepResolutionType resolution);
}
