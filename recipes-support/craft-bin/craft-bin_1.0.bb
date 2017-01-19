# Copyright (C) 2016 Stephano Cetola <stephano.cetola@linux.intel.com>
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Simple Binary Package"
HOMEPAGE = "http://www.example.com"
LICENSE = "CLOSED"
SECTION = "examples"
RDEPENDS_${PN} = "curl (>= 4)"

INSANE_SKIP_${PN} = "already-stripped ldflags"

inherit bin_package

SRC_URI = "file://craft-bin.tar.gz"

BBCLASSEXTEND = "native nativesdk"
EXPORT_MANIFEST = "1"
