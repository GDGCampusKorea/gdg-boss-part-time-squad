# Tuist
curl -Ls https://uninstall.tuist.io | bash
brew uninstall tuist
brew tap tuist/tuist
brew install tuist@4.21.2

# Permissions
sudo xattr -rd com.apple.quarantine /usr/local/bin/tuist
sudo xattr -rd com.apple.quarantine /usr/local/Cellar/tuist@4.21.2/4.21.2/lib/ProjectDescription.framework

# Generate Project
tuist clean && tuist install && tuist generate
