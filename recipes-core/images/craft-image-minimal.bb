DESCRIPTION = "A minimal console based image used for testing"

LICENSE = "MIT"

IMAGE_INSTALL_append = "\
    ${CORE_IMAGE_BASE_INSTALL} \
    openssh-sshd \
    openssh-ssh \
    openssh-scp \
    openssh-sftp-server \
    craft-version \
    craft-bin \
"

inherit core-image bin_validate

BIN_VAL_PKGS += " \
    craft-bin \
"

export IMAGE_BASENAME = "craft-image-minimal"
