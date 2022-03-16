Pod::Spec.new do |spec|
    spec.name                     = 'test'
    spec.version                  = '0.0.1'
    spec.homepage                 = 'https://github.com/cl3m/multiplatform-compose'
    spec.source                   = { :git => "Not Published", :tag => "Cocoapods/#{spec.name}/#{spec.version}" }
    spec.authors                  = ''
    spec.license                  = ''
    spec.summary                  = 'Multiplatform Compose Shared Test Module'

    spec.vendored_frameworks      = "build/cocoapods/framework/test.framework"
    spec.libraries                = "c++"
    spec.module_name              = "#{spec.name}_umbrella"

    spec.ios.deployment_target = '10.0'

    spec.dependency 'YogaKit', '~> 1.7'

    spec.pod_target_xcconfig = {
        'KOTLIN_PROJECT_PATH' => ':test',
        'PRODUCT_MODULE_NAME' => 'test',
    }

    spec.script_phases = [
        {
            :name => 'Build test',
            :execution_position => :before_compile,
            :shell_path => '/bin/sh',
            :script => <<-SCRIPT
                if [ "YES" = "$COCOAPODS_SKIP_KOTLIN_BUILD" ]; then
                  echo "Skipping Gradle build task invocation due to COCOAPODS_SKIP_KOTLIN_BUILD environment variable set to \"YES\""
                  exit 0
                fi
                set -ev
                REPO_ROOT="$PODS_TARGET_SRCROOT"
                "$REPO_ROOT/../gradlew" -p "$REPO_ROOT" $KOTLIN_PROJECT_PATH:syncFramework \
                    -Pkotlin.native.cocoapods.platform=$PLATFORM_NAME \
                    -Pkotlin.native.cocoapods.archs="$ARCHS" \
                    -Pkotlin.native.cocoapods.configuration=$CONFIGURATION
            SCRIPT
        }
    ]
end