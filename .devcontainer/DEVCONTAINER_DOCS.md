# DevContainer Configuration Documentation

## Overview

This document describes the GitHub Codespaces and Dev Container configuration for the Spock Template project. The configuration ensures a consistent development environment with Java 8 and Gradle 7.3.3 pre-installed.

## Files Structure

```
.devcontainer/
├── devcontainer.json       # Main configuration file
├── welcome.txt            # Welcome message displayed on attach
└── DEVCONTAINER_DOCS.md   # This documentation file
```

## Field-by-Field Explanation

This section provides a detailed explanation of each field in the `devcontainer.json` configuration file.

### Core Configuration

#### `name`
```json
"name": "Spock Template Development Environment"
```
**Purpose**: Display name for the dev container  
**Type**: String  
**Description**: This name appears in VS Code's UI when working with the container. It helps identify the environment when you have multiple dev containers.

#### `image`
```json
"image": "mcr.microsoft.com/devcontainers/java:1-8"
```
**Purpose**: Specifies the base Docker image  
**Type**: String (Docker image reference)  
**Description**: Uses Microsoft's official Java 8 dev container image. The format is `{registry}/{repository}:{tag}` where `1-8` means version 1 of the image with Java 8.  
**Alternatives**: You could use `dockerfile` instead to build a custom image.

### Customizations

#### `customizations.vscode.settings`
```json
"customizations": {
  "vscode": {
    "settings": { ... }
  }
}
```
**Purpose**: Configure VS Code settings specific to this container  
**Type**: Object  
**Description**: These settings override or supplement the user's VS Code settings when working in the container.

##### `java.home`
```json
"java.home": "/usr/local/sdkman/candidates/java/current"
```
**Purpose**: Tells VS Code where Java is installed  
**Type**: String (file path)  
**Description**: Points to the Java installation directory used by the Java extension.

##### `java.configuration.runtimes`
```json
"java.configuration.runtimes": [
  {
    "name": "JavaSE-1.8",
    "path": "/usr/local/sdkman/candidates/java/current"
  }
]
```
**Purpose**: Configures available Java runtimes for the project  
**Type**: Array of objects  
**Description**: Specifies Java 8 (JavaSE-1.8) as the runtime environment. This ensures the project compiles and runs with Java 8.

##### `gradle.nestedProjects`
```json
"gradle.nestedProjects": true
```
**Purpose**: Enable support for nested Gradle projects  
**Type**: Boolean  
**Description**: When `true`, the Gradle extension recognizes and handles nested project structures.

##### `groovy.classpath`
```json
"groovy.classpath": [
  "/workspaces/SpockTemplate/build/libs"
]
```
**Purpose**: Configure classpath for Groovy language support  
**Type**: Array of strings (file paths)  
**Description**: Tells the Groovy extension where to find compiled classes for better IntelliSense.

#### `customizations.vscode.extensions`
```json
"extensions": [
  "vscjava.vscode-java-pack",
  "vscjava.vscode-gradle",
  "marlon407.code-groovy",
  "redhat.java",
  "vscjava.vscode-java-debug",
  "vscjava.vscode-java-test",
  "vscjava.vscode-maven",
  "ms-azuretools.vscode-docker",
  "ritwickdey.liveserver"
]
```
**Purpose**: List of VS Code extensions to install automatically  
**Type**: Array of strings (extension IDs)  
**Description**: These extensions are installed when the container is created, providing Java, Gradle, Groovy, and testing support. Extension IDs follow the format `publisher.extension-name`.

 ### Lifecycle Commands

#### `postCreateCommand`
```json
"postCreateCommand": "chmod +x gradlew && ./gradlew --version && echo '\n✅ Environment ready! Run ./gradlew test to execute Spock tests.'"
```
**Purpose**: Run commands after the container is created  
**Type**: String or Array  
**When**: Runs once after the container is first created  
**Description**: Makes the Gradle wrapper executable, verifies the Gradle installation, and displays a success message. This is ideal for initial setup tasks like downloading dependencies.

#### `postStartCommand`
```json
"postStartCommand": "echo 'Welcome to Spock Template Development Environment!'"
```
**Purpose**: Run commands each time the container starts  
**Type**: String or Array  
**When**: Runs every time the container starts (after stop/restart)  
**Description**: Displays a welcome message. Use this for tasks that should run on every start, like starting background services.

#### `postAttachCommand`
```json
"postAttachCommand": "cat .devcontainer/welcome.txt"
```
**Purpose**: Run commands when VS Code attaches to the container  
**Type**: String or Array  
**When**: Runs when the editor connects to the container  
**Description**: Displays the contents of the welcome file. This is useful for showing helpful information when a developer opens the project.

### Environment Configuration

#### `remoteEnv`
```json
"remoteEnv": {
  "JAVA_HOME": "/usr/local/sdkman/candidates/java/current"
}
```
**Purpose**: Set environment variables in the container  
**Type**: Object (key-value pairs)  
**Description**: These environment variables are available to all processes in the container.

- **JAVA_HOME**: Standard environment variable pointing to Java installation. Gradle will use its default location (`~/.gradle`) for caching, which is automatically managed by the container.

#### `remoteUser`
```json
"remoteUser": "vscode"
```
**Purpose**: Specify which user to run as in the container  
**Type**: String (username)  
**Description**: Runs as the non-root `vscode` user for security. This user has sudo access if needed. To run as root, comment out this line or set it to `"root"`.

### Resource Requirements

#### `hostRequirements`
```json
"hostRequirements": {
  "cpus": 2,
  "memory": "4gb",
  "storage": "32gb"
}
```
**Purpose**: Specify minimum hardware requirements for GitHub Codespaces  
**Type**: Object  
**Description**: These are the default minimum resources for the Codespace machine. Users can choose larger machines if needed.

- **cpus**: Minimum number of CPU cores (2 is sufficient for most development)
- **memory**: Minimum RAM (4GB recommended for Java + Gradle)
- **storage**: Minimum disk space (32GB adequate for dependencies and build artifacts)

### Optional Fields (Not Currently Used)

#### `forwardPorts`
```json
// "forwardPorts": []
```
**Purpose**: Forward ports from the container to the local machine  
**Type**: Array of numbers  
**Example**: `"forwardPorts": [8080, 3000]`  
**Use Case**: If your application runs a web server, add its port here to access it from your browser.

#### `dockerfile`
```json
// "dockerfile": "Dockerfile"
```
**Purpose**: Build from a Dockerfile instead of using a pre-built image  
**Type**: String (file path)  
**Alternative to**: `image` field  
**Use Case**: When you need more control over the base image and installed software.

#### `build`
```json
// "build": {
//   "dockerfile": "Dockerfile",
//   "args": { ... }
// }
```
**Purpose**: Advanced build configuration for custom Dockerfiles  
**Type**: Object  
**Use Case**: Pass build arguments, specify context, or configure build options.

## Configuration Details

### Base Image

**Image**: `mcr.microsoft.com/devcontainers/java:1-8`

This is Microsoft's official Java 8 Dev Container image (version 1, Java 8), which includes:
- OpenJDK 8
- Common development tools (git, curl, wget, etc.)
- Node.js (for tooling)
- Pre-configured non-root user (`vscode`)

### Build Tools

**Gradle**: This project uses the Gradle wrapper (`./gradlew`) which is already included in the repository at version 7.3.3. No global Gradle installation is needed.

**Git**: Already included in the base Java image, so no additional feature is required.

### VS Code Extensions

The following extensions are automatically installed:

| Extension | Purpose |
|-----------|---------|
| `vscjava.vscode-java-pack` | Complete Java development support |
| `vscjava.vscode-gradle` | Gradle task running and project management |
| `marlon407.code-groovy` | Groovy language syntax highlighting |
| `redhat.java` | Java language server |
| `vscjava.vscode-java-debug` | Java debugging support |
| `vscjava.vscode-java-test` | Test runner for JUnit/Spock |
| `vscjava.vscode-maven` | Maven support (optional, for compatibility) |
| `ms-azuretools.vscode-docker` | Docker support |

### VS Code Settings

Custom settings applied in the container:

```json
"java.home": "/usr/local/sdkman/candidates/java/current"
```
- Points to Java 8 installation

```json
"java.configuration.runtimes": [...]
```
- Configures Java runtime for the project

```json
"gradle.nestedProjects": true
```
- Enables nested Gradle project support

### Lifecycle Commands

#### postCreateCommand
```bash
chmod +x gradlew && ./gradlew --version && echo '\n✅ Environment ready!'
```
- **When**: Runs once after container is created
- **Purpose**: 
  - Makes gradlew executable
  - Verifies Gradle installation
  - Downloads Gradle wrapper dependencies
  - Displays success message

#### postStartCommand
```bash
echo 'Welcome to Spock Template Development Environment!'
```
- **When**: Runs every time the container starts
- **Purpose**: Simple welcome message

#### postAttachCommand
```bash
cat .devcontainer/welcome.txt
```
- **When**: Runs when VS Code attaches to the container
- **Purpose**: Displays detailed welcome information with commands and tips

### Environment Variables

```json
"remoteEnv": {
  "GRADLE_USER_HOME": "/workspace/.gradle",
  "JAVA_HOME": "/usr/local/sdkman/candidates/java/current"
}
```

- `GRADLE_USER_HOME`: Keeps Gradle cache in workspace for faster rebuilds
- `JAVA_HOME`: Points to Java 8 installation

### Resource Requirements

```json
"hostRequirements": {
  "cpus": 2,
  "memory": "4gb",
  "storage": "32gb"
}
```

**Minimum requirements for GitHub Codespaces:**
- **CPUs**: 2 cores (sufficient for Gradle builds)
- **Memory**: 4GB (recommended for Java 8 + Gradle)
- **Storage**: 32GB (adequate for dependencies and build artifacts)

These are the default minimums; users can choose larger machines if needed.

### Remote User

```json
"remoteUser": "vscode"
```
- Runs as non-root user for security
- Standard practice for Dev Containers
- User has sudo access if needed

## Usage

### Starting a Codespace

1. **From GitHub.com:**
   - Navigate to the repository
   - Click "Code" → "Codespaces" → "Create codespace on main"
   - Wait for container to build and configure (~2-3 minutes first time)

2. **From VS Code:**
   - Install "GitHub Codespaces" extension
   - Open Command Palette (Cmd+Shift+P)
   - Select "Codespaces: Create New Codespace"

### First-Time Setup

The container will automatically:
1. Pull the Java 8 base image
2. Install Gradle 7.3.3
3. Install Git and GitHub CLI
4. Install all VS Code extensions
5. Make gradlew executable
6. Verify Gradle installation
7. Display welcome message

### Running Tests

Once the Codespace is ready:

```bash
# Run all tests
./gradlew test

# Run with more detail
./gradlew test --info

# Run specific test
./gradlew test --tests ExampleSpec

# Clean and test
./gradlew clean test
```

### Building the Project

```bash
# Build the project
./gradlew build

# Build without running tests
./gradlew build -x test

# Clean build
./gradlew clean build
```

## Customization Options

### Changing Java Version

To use a different Java version, modify `devcontainer.json`:

```json
"image": "mcr.microsoft.com/devcontainers/java:1-11"  // For Java 11
"image": "mcr.microsoft.com/devcontainers/java:1-17"  // For Java 17
"image": "mcr.microsoft.com/devcontainers/java:1-21"  // For Java 21
```

**Note**: Ensure `build.gradle` compatibility when changing Java versions.

### Changing Gradle Version

Update the Gradle feature version:

```json
"ghcr.io/devcontainers/features/gradle:1": {
  "version": "8.0"
}
```

Also update `gradle/wrapper/gradle-wrapper.properties` to match.

### Adding More Extensions

Add extension IDs to the `extensions` array:

```json
"extensions": [
  "existing-extensions...",
  "github.copilot",           // GitHub Copilot
  "eamodio.gitlens"          // GitLens
]
```

### Adding More Features

Browse available features at [containers.dev/features](https://containers.dev/features)

Example - adding Docker-in-Docker:

```json
"features": {
  "ghcr.io/devcontainers/features/docker-in-docker:2": {}
}
```

### Forwarding Ports

If your application runs a web server:

```json
"forwardPorts": [8080, 3000]
```

### Pre-building Commands

Add build steps before tests:

```json
"postCreateCommand": "chmod +x gradlew && ./gradlew build --no-daemon"
```

## Troubleshooting

### Issue: Gradle build fails

**Solution**: Check Java version compatibility
```bash
java -version
./gradlew --version
```

### Issue: Extensions not loading

**Solution**: Rebuild container
- Command Palette → "Codespaces: Rebuild Container"

### Issue: Out of memory

**Solution**: Use a larger Codespace machine
- 4-core (8GB RAM) or 8-core (16GB RAM)

### Issue: Slow performance

**Solution**: 
1. Check if initial download is complete
2. Increase machine size
3. Clear Gradle cache: `./gradlew clean`

## Additional Resources

- [Dev Containers Specification](https://containers.dev/)
- [GitHub Codespaces Documentation](https://docs.github.com/en/codespaces)
- [Spock Framework](https://spockframework.org/)
- [Gradle Documentation](https://docs.gradle.org/7.3.3/userguide/userguide.html)

## Maintenance

### Updating Dependencies

When updating project dependencies in `build.gradle`:

1. Commit the changes
2. Rebuild the Codespace container
3. Test the build: `./gradlew clean test`

### Updating DevContainer Configuration

After modifying `devcontainer.json`:

1. Commit the changes
2. Existing Codespaces need to be rebuilt
3. New Codespaces will use the updated configuration automatically

## Security Notes

- The container runs as non-root user (`vscode`)
- GitHub CLI is pre-authenticated with your GitHub credentials
- Secrets can be added via GitHub Codespaces secrets settings
- Never commit sensitive data to the repository

## Performance Tips

1. **Use Gradle Daemon**: Already configured in wrapper
2. **Parallel builds**: Add to `gradle.properties`:
   ```properties
   org.gradle.parallel=true
   org.gradle.caching=true
   ```
3. **Increase memory**: For large projects, use bigger machines
4. **Prebuilds**: Enable in repository settings for faster startup

---

**Last Updated**: February 2026  
**Configuration Version**: 1.0  
**Compatible with**: GitHub Codespaces, VS Code Dev Containers, any Dev Container spec implementation
