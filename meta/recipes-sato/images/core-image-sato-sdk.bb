require core-image-sato.bb

DESCRIPTION = "Image with Sato support that includes everything within \
core-image-sato plus meta-toolchain, development headers and libraries to \
form a standalone SDK."

IMAGE_FEATURES += "dev-pkgs tools-sdk qt4-pkgs \
	tools-debug tools-profile tools-testapps debug-tweaks ssh-server-openssh"

IMAGE_INSTALL += "kernel-dev"

