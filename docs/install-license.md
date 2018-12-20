Installing your license
=======================

Once you've [purchased a license](https://www.threshold.cloud/pricing), you need to install it into your Threshold server.

Installation consists of 3 steps:

1. Save your _License key_ from the end of the purchase process
2. Configure your license key file
3. Set your email address as an environment variable

Once you've completed these steps, Threshold is configured to use your license key.

## Prerequisites

Follow the [installation](install.md) instructions first.

## Step 1: Save license key

At the end of the purchase process your license key is generated:

![Purchase complete](https://raw.githubusercontent.com/gatehill/threshold-docs/master/docs/img/purchase_complete.png)

You should save this license key to a plain text file. We will use this in step 2.

## Step 2: Configure license key file

The easiest way to configure your license key file is to add it to the following location in your Threshold Gateway server:

    /opt/kamara/license/user.lic
 
If you are using Kubernetes, you can add your license file as a [ConfigMap](https://kubernetes.io/docs/tasks/configure-pod-container/configure-pod-configmap/) on the `threshold-gateway` _Deployment_ object.

> Note: in a multi-tenant or insecure environment you may choose instead to use a Kubernetes _Secret_ to protect against other processes reading your key. 

If you are using plain Docker or Docker Compose, you can [bind-mount](https://docs.docker.com/storage/bind-mounts/) the file instead.

### Customising location of license key file

If you wish to change the location of the license key file, you can override the default location by setting the `LICENSE_FILE` environment variable.

For example:

    LICENSE_FILE="/opt/kamara/license/my_custom_license_file.lic"

## Step 3: Configure email address

In order to verify your ownership of the license key, you need to provide the email address for which the license was purchased.

Set the following environment variable when starting the Threshold Gateway server:

    LICENSE_EMAIL="user@example.com"

If you are using Kubernetes, set the `LICENSE_EMAIL` [environment variable](https://kubernetes.io/docs/tasks/inject-data-application/define-environment-variable-container/) on the `threshold-gateway` _Deployment_ object.

If you are using Docker Compose, set the `LICENSE_EMAIL` environment variable using your [preferred method](https://docs.docker.com/compose/environment-variables/). 

## Complete

When complete, you should see the following output when starting the Threshold Gateway server:

```
License is valid until <expiry date>
```

If you see this message, the configuration is complete.

## Troubleshooting

### Message 'Cannot validate license'

If the license is not configured correctly, you may see the following message in the output of Threshold Gateway: 

```
*** WARNING *** Cannot validate license [file: /opt/kamara/license/user.lic] - application will terminate 10 minute(s) after startup!
```

Ensure that the license key file is in the correct location.

### Message 'Email address ... does not match'

If the email address does mot match the one you used when purchasing the license you may see this message:

```
Email address '<email address>' does not match license.
```

Please ensure you set the email address environment variable to the one used when you purchased your license. 

### Message 'License file ... has expired'

Your license has expired. Please obtain an updated license key.
