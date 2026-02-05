# GitHub Codespaces Quick Start Guide

This repository is configured with GitHub Codespaces for instant development environment setup!

## 🚀 Quick Start

### Option 1: Start from GitHub.com
1. Click the green **"Code"** button on this repository
2. Select the **"Codespaces"** tab
3. Click **"Create codespace on main"**
4. Wait 2-3 minutes for the environment to initialize
5. Start coding! 🎉

### Option 2: Start from VS Code Desktop
1. Install the [GitHub Codespaces extension](https://marketplace.visualstudio.com/items?itemName=GitHub.codespaces)
2. Press `Cmd+Shift+P` (macOS) or `Ctrl+Shift+P` (Windows/Linux)
3. Type "Codespaces: Create New Codespace"
4. Select this repository
5. Wait for initialization

## 📦 What's Included

Your Codespace comes pre-configured with:
- ☕ **Java 8** (OpenJDK 8)
- 🐘 **Gradle 7.3.3** (via wrapper)
- 🎭 **Groovy 4.0.16**
- 🖖 **Spock Framework 2.3**
- 🔧 **VS Code Extensions** for Java, Gradle, and Groovy
- 🎯 **Git** (included in base image)

## ✅ First Steps

Once your Codespace is ready, try these commands:

```bash
# Verify the environment
java -version
./gradlew --version

# Run the example test
./gradlew test

# Build the project
./gradlew build

# See all available tasks
./gradlew tasks
```

## 📁 Project Structure

```
SpockTemplate/
├── src/
│   └── test/
│       └── groovy/
│           └── io/github/joxebus/test/
│               └── ExampleSpec.groovy    # Example Spock test
├── .devcontainer/
│   ├── devcontainer.json                # Codespace configuration
│   ├── DEVCONTAINER_DOCS.md             # Detailed documentation
│   └── welcome.txt                       # Welcome message
├── build.gradle                          # Gradle build configuration
└── gradlew                               # Gradle wrapper script
```

## 🧪 Writing Tests

Spock tests use a BDD (Behavior-Driven Development) style with Groovy:

```groovy
def "test description"() {
    given: "setup description"
    // Setup code
    
    when: "action description"
    // Action code
    
    then: "expected result description"
    // Assertions
}
```

Check `src/test/groovy/io/github/joxebus/test/ExampleSpec.groovy` for a working example.

## 🎯 Common Commands

| Command | Description |
|---------|-------------|
| `./gradlew test` | Run all tests |
| `./gradlew test --tests ClassName` | Run specific test class |
| `./gradlew build` | Build the project |
| `./gradlew clean` | Clean build artifacts |
| `./gradlew tasks` | List all available Gradle tasks |
| `./gradlew test --info` | Run tests with detailed output |

## 🔧 Customizing Your Codespace

Want to modify your development environment? Check out:
- `.devcontainer/devcontainer.json` - Main configuration file
- `.devcontainer/DEVCONTAINER_DOCS.md` - Comprehensive documentation

## 💡 Tips

1. **Gradle Wrapper**: Always use `./gradlew` instead of `gradle` to ensure version consistency
2. **Tests Location**: Put your Spock tests in `src/test/groovy/`
3. **Source Code**: Add Java/Groovy source files in `src/main/java/` or `src/main/groovy/`
4. **Rebuild Container**: If you modify `.devcontainer/devcontainer.json`, rebuild via Command Palette → "Codespaces: Rebuild Container"

## 🐛 Troubleshooting

### Build fails?
```bash
./gradlew clean build
```

### Need more memory?
Stop your Codespace and restart with a larger machine size (4-core or 8-core).

### Extensions not working?
Rebuild the container:
- Command Palette (`Cmd+Shift+P`) → "Codespaces: Rebuild Container"

## 📚 Additional Resources

- [Spock Framework Documentation](https://spockframework.org/)
- [Gradle User Guide](https://docs.gradle.org/7.3.3/userguide/userguide.html)
- [GitHub Codespaces Docs](https://docs.github.com/en/codespaces)
- [Dev Containers Specification](https://containers.dev/)
- [Groovy Language](https://groovy-lang.org/)

## 🎓 Learning Resources

### Spock Framework
- [Spock Primer](https://spockframework.org/spock/docs/2.3/index.html)
- [Data Driven Testing](https://spockframework.org/spock/docs/2.3/data_driven_testing.html)
- [Interaction Based Testing](https://spockframework.org/spock/docs/2.3/interaction_based_testing.html)

### Groovy
- [Groovy Style Guide](https://groovy-lang.org/style-guide.html)
- [Groovy Documentation](https://groovy-lang.org/documentation.html)

---

**Need Help?** Open an issue or check the detailed documentation in `.devcontainer/DEVCONTAINER_DOCS.md`

Happy Testing! 🚀
