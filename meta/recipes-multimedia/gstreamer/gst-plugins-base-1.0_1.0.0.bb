require gst-plugins-1.0.inc

LICENSE = "GPLv2+ & LGPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=0636e73ff0215e8d672dc4c32c317bb3 \
                    file://common/coverage/coverage-report.pl;beginline=2;endline=17;md5=622921ffad8cb18ab906c56052788a3f \
                    file://COPYING.LIB;md5=55ca817ccb7d5b5b66355690e9abc605"

DEPENDS += "${@base_contains('DISTRO_FEATURES', 'x11', 'virtual/libx11 libxv', '', d)}"
DEPENDS += "alsa-lib freetype liboil libogg libvorbis libtheora util-linux tremor"

SRC_URI = "http://gstreamer.freedesktop.org/src/gst-plugins-base/gst-plugins-base-${PV}.tar.xz"
S = "${WORKDIR}/gst-plugins-base-${PV}"

SRC_URI[md5sum] = "428f5a0beaa7f76262bea0f431f8337e"
SRC_URI[sha256sum] = "4b98a74712e31d5426dd1cf2de883b6af59fd37997b0ffaed53914eb6df45053"

PR = "r1"

inherit gettext

EXTRA_OECONF += "--disable-freetypetest --disable-pango --disable-gnome_vfs --disable-orc"

do_configure_prepend() {
	# This m4 file contains nastiness which conflicts with libtool 2.2.2
	rm -f ${S}/m4/lib-link.m4
}

FILES_${PN} += "${PLUGINS_DIR}/*.so"
