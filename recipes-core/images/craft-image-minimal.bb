DESCRIPTION = "A minimal console based image used for testing"

LICENSE = "MIT"

IMAGE_INSTALL_append = "\
    ${CORE_IMAGE_BASE_INSTALL} \
    openssh-sshd \
    openssh-ssh \
    openssh-scp \
    openssh-sftp-server \
    craft-version \
"

inherit core-image

export IMAGE_BASENAME = "craft-image-minimal"
