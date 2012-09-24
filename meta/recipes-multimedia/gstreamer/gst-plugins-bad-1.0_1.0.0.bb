require gst-plugins-1.0.inc

LICENSE = "GPLv2+ & LGPLv2+ & LGPLv2.1+ "
LIC_FILES_CHKSUM = "file://COPYING;md5=73a5855a8119deb017f5f13cf327095d \
                    file://gst/tta/filters.h;beginline=12;endline=29;md5=8a08270656f2f8ad7bb3655b83138e5a \
                    file://COPYING.LIB;md5=21682e4e8fea52413fd26c60acb907e5 \
                    file://gst/tta/crc32.h;beginline=12;endline=29;md5=71a904d99ce7ae0c1cf129891b98145c"

DEPENDS += "gst-plugins-base-1.0 libmusicbrainz tremor librsvg curl"

PR = "r1"

SRC_URI = "http://gstreamer.freedesktop.org/src/gst-plugins-bad/gst-plugins-bad-${PV}.tar.xz"
S = "${WORKDIR}/gst-plugins-bad-${PV}"

inherit gettext

EXTRA_OECONF += "--disable-examples --disable-experimental --disable-sdl --disable-cdaudio --disable-directfb \
                 --with-plugins=musicbrainz,wavpack,ivorbis,mpegvideoparse --disable-vdpau --disable-apexsink \
                 --disable-orc"

ARM_INSTRUCTION_SET = "arm"

do_configure_prepend() {
	# This m4 file contains nastiness which conflicts with libtool 2.2.2
	rm ${S}/m4/lib-link.m4 || true
}

SRC_URI[md5sum] = "f2d2c432917fb639a510bb3ce85c5329"
SRC_URI[sha256sum] = "9af78a20a535687bfbb58128713376f3f5ae670af8afb3be4285713557c2381b"

FILES_${PN} += "${PLUGINS_DIR}/*.so"
