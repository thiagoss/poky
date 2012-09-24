require gst-plugins-1.0.inc

LICENSE = "GPLv2+ & LGPLv2.1+ & LGPLv2+"
LICENSE_FLAGS = "commercial"
LIC_FILES_CHKSUM = "file://COPYING;md5=a6f89e2100d9b6cdffcea4f398e37343 \
                    file://tests/check/elements/xingmux.c;beginline=1;endline=21;md5=4c771b8af188724855cb99cadd390068"

DEPENDS += "gst-plugins-base-1.0 libid3tag libmad mpeg2dec liba52 lame"
PR = "r1"

SRC_URI = "http://gstreamer.freedesktop.org/src/gst-plugins-ugly/gst-plugins-ugly-${PV}.tar.xz"
S = "${WORKDIR}/gst-plugins-ugly-${PV}"

inherit gettext

EXTRA_OECONF += "--with-plugins=a52dec,lame,id3tag,mad,mpeg2dec,mpegstream,mpegaudioparse,asfdemux,realmedia \
                 --disable-orc"

do_configure_prepend() {
	# This m4 file contains nastiness which conflicts with libtool 2.2.2
	rm ${S}/m4/lib-link.m4 || true
}

SRC_URI[md5sum] = "7f20303caf4305278573fb7ef73a07b7"
SRC_URI[sha256sum] = "d0d21777d16afae3064e0d660cbe46eaabf889fa7f60b065ead8b3d1108a905d"

FILES_${PN} += "${PLUGINS_DIR}/*.so"
