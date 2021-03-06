/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.cloud.logging.spi.v2;

import com.google.api.gax.core.PagedListResponse;
import com.google.api.gax.grpc.ApiCallable;
import com.google.api.gax.protobuf.PathTemplate;
import com.google.logging.v2.CreateLogMetricRequest;
import com.google.logging.v2.DeleteLogMetricRequest;
import com.google.logging.v2.GetLogMetricRequest;
import com.google.logging.v2.ListLogMetricsRequest;
import com.google.logging.v2.ListLogMetricsResponse;
import com.google.logging.v2.LogMetric;
import com.google.logging.v2.UpdateLogMetricRequest;
import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Service for configuring logs-based metrics.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (MetricsServiceV2Api metricsServiceV2Api = MetricsServiceV2Api.create()) {
 *   String formattedMetricName = MetricsServiceV2Api.formatMetricName("[PROJECT]", "[METRIC]");
 *   LogMetric response = metricsServiceV2Api.getLogMetric(formattedMetricName);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the metricsServiceV2Api object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's methods:
 *
 * <ol>
 * <li> A "flattened" method. With this type of method, the fields of the request type have been
 * converted into function parameters. It may be the case that not all fields are available
 * as parameters, and not every API method will have a flattened method entry point.
 * <li> A "request object" method. This type of method only takes one parameter, a request
 * object, which must be constructed before the call. Not every API method will have a request
 * object method.
 * <li> A "callable" method. This type of method takes no parameters and returns an immutable
 * ApiCallable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist
 * with these names, this class includes a format method for each type of name, and additionally
 * a parse method to extract the individual identifiers contained within names that are
 * returned.
 *
 * <p>This class can be customized by passing in a custom instance of MetricsServiceV2Settings to
 * create(). For example:
 *
 * <pre>
 * <code>
 * MetricsServiceV2Settings metricsServiceV2Settings = MetricsServiceV2Settings.defaultBuilder()
 *     .provideChannelWith(myCredentials)
 *     .build();
 * MetricsServiceV2Api metricsServiceV2Api = MetricsServiceV2Api.create(metricsServiceV2Settings);
 * </code>
 * </pre>
 */
@javax.annotation.Generated("by GAPIC")
public class MetricsServiceV2Api implements AutoCloseable {
  private final MetricsServiceV2Settings settings;
  private final ManagedChannel channel;
  private final ScheduledExecutorService executor;
  private final List<AutoCloseable> closeables = new ArrayList<>();

  private final ApiCallable<ListLogMetricsRequest, ListLogMetricsResponse> listLogMetricsCallable;
  private final ApiCallable<
          ListLogMetricsRequest,
          PagedListResponse<ListLogMetricsRequest, ListLogMetricsResponse, LogMetric>>
      listLogMetricsPagedCallable;
  private final ApiCallable<GetLogMetricRequest, LogMetric> getLogMetricCallable;
  private final ApiCallable<CreateLogMetricRequest, LogMetric> createLogMetricCallable;
  private final ApiCallable<UpdateLogMetricRequest, LogMetric> updateLogMetricCallable;
  private final ApiCallable<DeleteLogMetricRequest, Empty> deleteLogMetricCallable;

  public final MetricsServiceV2Settings getSettings() {
    return settings;
  }

  private static final PathTemplate PARENT_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}");

  private static final PathTemplate METRIC_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/metrics/{metric}");

  /**
   * Formats a string containing the fully-qualified path to represent
   * a parent resource.
   */
  public static final String formatParentName(String project) {
    return PARENT_PATH_TEMPLATE.instantiate("project", project);
  }

  /**
   * Formats a string containing the fully-qualified path to represent
   * a metric resource.
   */
  public static final String formatMetricName(String project, String metric) {
    return METRIC_PATH_TEMPLATE.instantiate(
        "project", project,
        "metric", metric);
  }

  /**
   * Parses the project from the given fully-qualified path which
   * represents a parent resource.
   */
  public static final String parseProjectFromParentName(String parentName) {
    return PARENT_PATH_TEMPLATE.parse(parentName).get("project");
  }

  /**
   * Parses the project from the given fully-qualified path which
   * represents a metric resource.
   */
  public static final String parseProjectFromMetricName(String metricName) {
    return METRIC_PATH_TEMPLATE.parse(metricName).get("project");
  }

  /**
   * Parses the metric from the given fully-qualified path which
   * represents a metric resource.
   */
  public static final String parseMetricFromMetricName(String metricName) {
    return METRIC_PATH_TEMPLATE.parse(metricName).get("metric");
  }

  /**
   * Constructs an instance of MetricsServiceV2Api with default settings.
   */
  public static final MetricsServiceV2Api create() throws IOException {
    return create(MetricsServiceV2Settings.defaultBuilder().build());
  }

  /**
   * Constructs an instance of MetricsServiceV2Api, using the given settings.
   * The channels are created based on the settings passed in, or defaults for any
   * settings that are not set.
   */
  public static final MetricsServiceV2Api create(MetricsServiceV2Settings settings)
      throws IOException {
    return new MetricsServiceV2Api(settings);
  }

  /**
   * Constructs an instance of MetricsServiceV2Api, using the given settings.
   * This is protected so that it easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected MetricsServiceV2Api(MetricsServiceV2Settings settings) throws IOException {
    this.settings = settings;
    this.executor = settings.getExecutorProvider().getOrBuildExecutor();
    this.channel = settings.getChannelProvider().getOrBuildChannel(this.executor);

    this.listLogMetricsCallable =
        ApiCallable.create(settings.listLogMetricsSettings(), this.channel, this.executor);
    this.listLogMetricsPagedCallable =
        ApiCallable.createPagedVariant(
            settings.listLogMetricsSettings(), this.channel, this.executor);
    this.getLogMetricCallable =
        ApiCallable.create(settings.getLogMetricSettings(), this.channel, this.executor);
    this.createLogMetricCallable =
        ApiCallable.create(settings.createLogMetricSettings(), this.channel, this.executor);
    this.updateLogMetricCallable =
        ApiCallable.create(settings.updateLogMetricSettings(), this.channel, this.executor);
    this.deleteLogMetricCallable =
        ApiCallable.create(settings.deleteLogMetricSettings(), this.channel, this.executor);

    if (settings.getChannelProvider().shouldAutoClose()) {
      closeables.add(
          new Closeable() {
            @Override
            public void close() throws IOException {
              channel.shutdown();
            }
          });
    }
    if (settings.getExecutorProvider().shouldAutoClose()) {
      closeables.add(
          new Closeable() {
            @Override
            public void close() throws IOException {
              executor.shutdown();
            }
          });
    }
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists logs-based metrics.
   *
   * Sample code:
   * <pre><code>
   * try (MetricsServiceV2Api metricsServiceV2Api = MetricsServiceV2Api.create()) {
   *   String formattedParent = MetricsServiceV2Api.formatParentName("[PROJECT]");
   *   for (LogMetric element : metricsServiceV2Api.listLogMetrics(formattedParent).iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The resource name containing the metrics.
   * Example: `"projects/my-project-id"`.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final PagedListResponse<ListLogMetricsRequest, ListLogMetricsResponse, LogMetric>
      listLogMetrics(String parent) {
    PARENT_PATH_TEMPLATE.validate(parent, "listLogMetrics");
    ListLogMetricsRequest request = ListLogMetricsRequest.newBuilder().setParent(parent).build();
    return listLogMetrics(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists logs-based metrics.
   *
   * Sample code:
   * <pre><code>
   * try (MetricsServiceV2Api metricsServiceV2Api = MetricsServiceV2Api.create()) {
   *   String formattedParent = MetricsServiceV2Api.formatParentName("[PROJECT]");
   *   ListLogMetricsRequest request = ListLogMetricsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   for (LogMetric element : metricsServiceV2Api.listLogMetrics(request).iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final PagedListResponse<ListLogMetricsRequest, ListLogMetricsResponse, LogMetric>
      listLogMetrics(ListLogMetricsRequest request) {
    return listLogMetricsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists logs-based metrics.
   *
   * Sample code:
   * <pre><code>
   * try (MetricsServiceV2Api metricsServiceV2Api = MetricsServiceV2Api.create()) {
   *   String formattedParent = MetricsServiceV2Api.formatParentName("[PROJECT]");
   *   ListLogMetricsRequest request = ListLogMetricsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   ListenableFuture&lt;PagedListResponse&lt;ListLogMetricsRequest,ListLogMetricsResponse,LogMetric&gt;&gt; future = metricsServiceV2Api.listLogMetricsPagedCallable().futureCall(request);
   *   // Do something
   *   for (LogMetric element : future.get().iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final ApiCallable<
          ListLogMetricsRequest,
          PagedListResponse<ListLogMetricsRequest, ListLogMetricsResponse, LogMetric>>
      listLogMetricsPagedCallable() {
    return listLogMetricsPagedCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists logs-based metrics.
   *
   * Sample code:
   * <pre><code>
   * try (MetricsServiceV2Api metricsServiceV2Api = MetricsServiceV2Api.create()) {
   *   String formattedParent = MetricsServiceV2Api.formatParentName("[PROJECT]");
   *   ListLogMetricsRequest request = ListLogMetricsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   while (true) {
   *     ListLogMetricsResponse response = metricsServiceV2Api.listLogMetricsCallable().call(request);
   *     for (LogMetric element : response.getMetricsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * </code></pre>
   */
  public final ApiCallable<ListLogMetricsRequest, ListLogMetricsResponse> listLogMetricsCallable() {
    return listLogMetricsCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a logs-based metric.
   *
   * Sample code:
   * <pre><code>
   * try (MetricsServiceV2Api metricsServiceV2Api = MetricsServiceV2Api.create()) {
   *   String formattedMetricName = MetricsServiceV2Api.formatMetricName("[PROJECT]", "[METRIC]");
   *   LogMetric response = metricsServiceV2Api.getLogMetric(formattedMetricName);
   * }
   * </code></pre>
   *
   * @param metricName The resource name of the desired metric.
   * Example: `"projects/my-project-id/metrics/my-metric-id"`.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final LogMetric getLogMetric(String metricName) {
    METRIC_PATH_TEMPLATE.validate(metricName, "getLogMetric");
    GetLogMetricRequest request =
        GetLogMetricRequest.newBuilder().setMetricName(metricName).build();
    return getLogMetric(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a logs-based metric.
   *
   * Sample code:
   * <pre><code>
   * try (MetricsServiceV2Api metricsServiceV2Api = MetricsServiceV2Api.create()) {
   *   String formattedMetricName = MetricsServiceV2Api.formatMetricName("[PROJECT]", "[METRIC]");
   *   GetLogMetricRequest request = GetLogMetricRequest.newBuilder()
   *     .setMetricName(formattedMetricName)
   *     .build();
   *   LogMetric response = metricsServiceV2Api.getLogMetric(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  private final LogMetric getLogMetric(GetLogMetricRequest request) {
    return getLogMetricCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a logs-based metric.
   *
   * Sample code:
   * <pre><code>
   * try (MetricsServiceV2Api metricsServiceV2Api = MetricsServiceV2Api.create()) {
   *   String formattedMetricName = MetricsServiceV2Api.formatMetricName("[PROJECT]", "[METRIC]");
   *   GetLogMetricRequest request = GetLogMetricRequest.newBuilder()
   *     .setMetricName(formattedMetricName)
   *     .build();
   *   ListenableFuture&lt;LogMetric&gt; future = metricsServiceV2Api.getLogMetricCallable().futureCall(request);
   *   // Do something
   *   LogMetric response = future.get();
   * }
   * </code></pre>
   */
  public final ApiCallable<GetLogMetricRequest, LogMetric> getLogMetricCallable() {
    return getLogMetricCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a logs-based metric.
   *
   * Sample code:
   * <pre><code>
   * try (MetricsServiceV2Api metricsServiceV2Api = MetricsServiceV2Api.create()) {
   *   String formattedParent = MetricsServiceV2Api.formatParentName("[PROJECT]");
   *   LogMetric metric = LogMetric.newBuilder().build();
   *   LogMetric response = metricsServiceV2Api.createLogMetric(formattedParent, metric);
   * }
   * </code></pre>
   *
   * @param parent The resource name of the project in which to create the metric.
   * Example: `"projects/my-project-id"`.
   *
   * The new metric must be provided in the request.
   * @param metric The new logs-based metric, which must not have an identifier that
   * already exists.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final LogMetric createLogMetric(String parent, LogMetric metric) {
    PARENT_PATH_TEMPLATE.validate(parent, "createLogMetric");
    CreateLogMetricRequest request =
        CreateLogMetricRequest.newBuilder().setParent(parent).setMetric(metric).build();
    return createLogMetric(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a logs-based metric.
   *
   * Sample code:
   * <pre><code>
   * try (MetricsServiceV2Api metricsServiceV2Api = MetricsServiceV2Api.create()) {
   *   String formattedParent = MetricsServiceV2Api.formatParentName("[PROJECT]");
   *   LogMetric metric = LogMetric.newBuilder().build();
   *   CreateLogMetricRequest request = CreateLogMetricRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setMetric(metric)
   *     .build();
   *   LogMetric response = metricsServiceV2Api.createLogMetric(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final LogMetric createLogMetric(CreateLogMetricRequest request) {
    return createLogMetricCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a logs-based metric.
   *
   * Sample code:
   * <pre><code>
   * try (MetricsServiceV2Api metricsServiceV2Api = MetricsServiceV2Api.create()) {
   *   String formattedParent = MetricsServiceV2Api.formatParentName("[PROJECT]");
   *   LogMetric metric = LogMetric.newBuilder().build();
   *   CreateLogMetricRequest request = CreateLogMetricRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setMetric(metric)
   *     .build();
   *   ListenableFuture&lt;LogMetric&gt; future = metricsServiceV2Api.createLogMetricCallable().futureCall(request);
   *   // Do something
   *   LogMetric response = future.get();
   * }
   * </code></pre>
   */
  public final ApiCallable<CreateLogMetricRequest, LogMetric> createLogMetricCallable() {
    return createLogMetricCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates or updates a logs-based metric.
   *
   * Sample code:
   * <pre><code>
   * try (MetricsServiceV2Api metricsServiceV2Api = MetricsServiceV2Api.create()) {
   *   String formattedMetricName = MetricsServiceV2Api.formatMetricName("[PROJECT]", "[METRIC]");
   *   LogMetric metric = LogMetric.newBuilder().build();
   *   LogMetric response = metricsServiceV2Api.updateLogMetric(formattedMetricName, metric);
   * }
   * </code></pre>
   *
   * @param metricName The resource name of the metric to update.
   * Example: `"projects/my-project-id/metrics/my-metric-id"`.
   *
   * The updated metric must be provided in the request and have the
   * same identifier that is specified in `metricName`.
   * If the metric does not exist, it is created.
   * @param metric The updated metric, whose name must be the same as the
   * metric identifier in `metricName`. If `metricName` does not
   * exist, then a new metric is created.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final LogMetric updateLogMetric(String metricName, LogMetric metric) {
    METRIC_PATH_TEMPLATE.validate(metricName, "updateLogMetric");
    UpdateLogMetricRequest request =
        UpdateLogMetricRequest.newBuilder().setMetricName(metricName).setMetric(metric).build();
    return updateLogMetric(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates or updates a logs-based metric.
   *
   * Sample code:
   * <pre><code>
   * try (MetricsServiceV2Api metricsServiceV2Api = MetricsServiceV2Api.create()) {
   *   String formattedMetricName = MetricsServiceV2Api.formatMetricName("[PROJECT]", "[METRIC]");
   *   LogMetric metric = LogMetric.newBuilder().build();
   *   UpdateLogMetricRequest request = UpdateLogMetricRequest.newBuilder()
   *     .setMetricName(formattedMetricName)
   *     .setMetric(metric)
   *     .build();
   *   LogMetric response = metricsServiceV2Api.updateLogMetric(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final LogMetric updateLogMetric(UpdateLogMetricRequest request) {
    return updateLogMetricCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates or updates a logs-based metric.
   *
   * Sample code:
   * <pre><code>
   * try (MetricsServiceV2Api metricsServiceV2Api = MetricsServiceV2Api.create()) {
   *   String formattedMetricName = MetricsServiceV2Api.formatMetricName("[PROJECT]", "[METRIC]");
   *   LogMetric metric = LogMetric.newBuilder().build();
   *   UpdateLogMetricRequest request = UpdateLogMetricRequest.newBuilder()
   *     .setMetricName(formattedMetricName)
   *     .setMetric(metric)
   *     .build();
   *   ListenableFuture&lt;LogMetric&gt; future = metricsServiceV2Api.updateLogMetricCallable().futureCall(request);
   *   // Do something
   *   LogMetric response = future.get();
   * }
   * </code></pre>
   */
  public final ApiCallable<UpdateLogMetricRequest, LogMetric> updateLogMetricCallable() {
    return updateLogMetricCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a logs-based metric.
   *
   * Sample code:
   * <pre><code>
   * try (MetricsServiceV2Api metricsServiceV2Api = MetricsServiceV2Api.create()) {
   *   String formattedMetricName = MetricsServiceV2Api.formatMetricName("[PROJECT]", "[METRIC]");
   *   metricsServiceV2Api.deleteLogMetric(formattedMetricName);
   * }
   * </code></pre>
   *
   * @param metricName The resource name of the metric to delete.
   * Example: `"projects/my-project-id/metrics/my-metric-id"`.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final void deleteLogMetric(String metricName) {
    METRIC_PATH_TEMPLATE.validate(metricName, "deleteLogMetric");
    DeleteLogMetricRequest request =
        DeleteLogMetricRequest.newBuilder().setMetricName(metricName).build();
    deleteLogMetric(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a logs-based metric.
   *
   * Sample code:
   * <pre><code>
   * try (MetricsServiceV2Api metricsServiceV2Api = MetricsServiceV2Api.create()) {
   *   String formattedMetricName = MetricsServiceV2Api.formatMetricName("[PROJECT]", "[METRIC]");
   *   DeleteLogMetricRequest request = DeleteLogMetricRequest.newBuilder()
   *     .setMetricName(formattedMetricName)
   *     .build();
   *   metricsServiceV2Api.deleteLogMetric(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  private final void deleteLogMetric(DeleteLogMetricRequest request) {
    deleteLogMetricCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a logs-based metric.
   *
   * Sample code:
   * <pre><code>
   * try (MetricsServiceV2Api metricsServiceV2Api = MetricsServiceV2Api.create()) {
   *   String formattedMetricName = MetricsServiceV2Api.formatMetricName("[PROJECT]", "[METRIC]");
   *   DeleteLogMetricRequest request = DeleteLogMetricRequest.newBuilder()
   *     .setMetricName(formattedMetricName)
   *     .build();
   *   ListenableFuture&lt;Void&gt; future = metricsServiceV2Api.deleteLogMetricCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final ApiCallable<DeleteLogMetricRequest, Empty> deleteLogMetricCallable() {
    return deleteLogMetricCallable;
  }

  /**
   * Initiates an orderly shutdown in which preexisting calls continue but new calls are immediately
   * cancelled.
   */
  @Override
  public final void close() throws Exception {
    for (AutoCloseable closeable : closeables) {
      closeable.close();
    }
  }
}
